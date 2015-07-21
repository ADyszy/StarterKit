package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 * <li>node id should have 4 characters</li>
 * <li>node description can have maximal 128 characters</li>
 * <li>no cycle</li> ?
 * <li>only penultimate can have two subsequent</li>
 * </ul>
 */

public class NodeValidators {

	private static final int MAX_ID_LENGTH = 4;
	private static final int MAX_DESCRIPTION_LENGTH = 128;

	public boolean validateID(List<Node> nodes) {
		for (Node n : nodes) {
			if (n.getId().length() != MAX_ID_LENGTH)
				NodeValidatorException.exList
						.add(new InvalidIDException("Invalid ID. 4 characters expected.[node_id: " + n.getId() + "]"));
		}
		return true;
	}

	public boolean validateDescription(List<Node> nodes) {
		for (Node n : nodes) {
			if (n.getDescription().length() > MAX_DESCRIPTION_LENGTH)
				NodeValidatorException.exList.add(new InvalidDescriptionException(
						"Invalid description. Max. 128 characters expected. [node_id: " + n.getId() + "]"));
		}
		return true;
	}

	public boolean hasSubsequent(List<Node> nodes, Node node) {
		for (Node n : nodes) {
			if (n.getPredecessorId() != null)
				if (n.getPredecessorId().equals(node.getId()))
					return true;
		}
		return false;
	}

	public boolean hasPredecessor(Node node) {
		return (node.getPredecessorId() == null) ? false : true;
	}

	public List<Node> findSubsequents(List<Node> nodes, Node node) {
		List<Node> subs = new ArrayList<Node>();
		for (Node n : nodes) {
			if (hasPredecessor(n) && n.getPredecessorId().equals(node.getId()))
				subs.add(n);
		}
		return subs;
	}

	private boolean ifAnyNodeOfListHasASubsequent(List<Node> nodeList, List<Node> nodes) {
		for (Node node : nodeList)
			if (hasSubsequent(nodes, node))
				return true;
		return false;
	}

	public boolean validateSubsequents(List<Node> nodes) {
		int count = 0;
		List<Node> subsList = null;
		for (Node node : nodes) {
			subsList = findSubsequents(nodes, node);
			int subsCount = subsList.size();
			if (subsCount > 2)
				NodeValidatorException.exList.add(new InvalidSubsequentException(
						"A node has more than two sub-s. [node_id: " + node.getId() + "]"));
			if (subsCount == 2) {
				if (++count > 1)
					NodeValidatorException.exList
							.add(new InvalidSubsequentException("More than one node with two sub-s."));
				if (ifAnyNodeOfListHasASubsequent(subsList, nodes))
					NodeValidatorException.exList.add(new InvalidSubsequentException(
							"Not penultimate have two subsequent. [node_id: " + node.getId() + "]"));
			}
		}
		return true;
	}

	private boolean removeNodesWithoutPredecessors(List<Node> nodes) {
		boolean removed = false;

		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getPredecessorId() == null) {
				List<Node> tmps = findSubsequents(nodes, nodes.get(i));
				for (Node tmp : tmps) {
					tmp.setPredecessorId(null);
					nodes.remove(nodes.get(i));
					removed = true;
				}
			}
		}
		return removed;
	}

	public boolean validateCycles(List<Node> nodes) { 
		List<Node> nodesCpy = Node.copyList(nodes);
		boolean goOn = true;
		while (nodesCpy.size() > 1 && goOn) {
			goOn = removeNodesWithoutPredecessors(nodesCpy);
		}
		if (nodesCpy.size() > 2) {
			NodeValidatorException.exList.add(new CycledGraphException("Graph has cycles."));
		}
		return true;
	}

	public void validateMethod(List<Node> nodes) throws NodeValidatorException {

		validateID(nodes);
		validateDescription(nodes);
		validateCycles(nodes);
		validateSubsequents(nodes);

		if (NodeValidatorException.occured())
			throw new NodeValidatorException();

	}

}
