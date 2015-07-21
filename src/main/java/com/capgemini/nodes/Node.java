package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node {
	private String id;
	private String description;
	private String predecessorId;

	public void copyTo(Node n) {
		n.setId(id);
		n.setDescription(description);
		n.setPredecessorId(predecessorId);
	}

	public static List<Node> copyList(List<Node> list) {
		List<Node> newList = new ArrayList<Node>();
		for (Node node : list) {
			Node n = new Node();
			node.copyTo(n);
			newList.add(n);
		}
		return newList;
	}

	public Node(String id, String description, String predecessorID) {
		setDescription(description);
		setId(id);
		setPredecessorId(predecessorID);
	}

	public Node() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPredecessorId() {
		return predecessorId;
	}

	public void setPredecessorId(String predecessorId) {
		this.predecessorId = predecessorId;
	}

}
