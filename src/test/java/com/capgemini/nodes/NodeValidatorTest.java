package com.capgemini.nodes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NodeValidatorTest {
	
	@Test(expected = NodeValidatorException.class)
	public void shouldInvalidID() throws NodeValidatorException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("12345", "Description", null));
		nv.validateMethod(nodes);
		boolean invalidID = (NodeValidatorException.exList.get(0) instanceof InvalidIDException);
		Assert.assertEquals(true, invalidID);
	}

	@Test
	public void shouldValidID() throws InvalidIDException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("1234", "Description", null));
		Assert.assertEquals(true, nv.validateID(nodes));
	}

	@Test
	public void shouldValidDescription() throws InvalidDescriptionException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("1234", "Description", null));
		Assert.assertEquals(true, nv.validateDescription(nodes));
	}

	@Test
	public void shouldFindTwoSubsequent() {

		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("5555", "Description", null));
		nodes.add(new Node("4444", "Description", "5555"));
		Node n = new Node("3333", "Description", "4444");
		nodes.add(n);
		nodes.add(new Node("2222", "Description", "3333"));
		nodes.add(new Node("1111", "Description", "3333"));

		Assert.assertEquals(2, nv.findSubsequents(nodes, n).size());
	}

	@Test
	public void shouldHaveSubsequent() {

		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		Node n = new Node("2222", "Description", null);
		nodes.add(n);
		nodes.add(new Node("1111", "Description", "2222"));

		Assert.assertEquals(true, nv.hasSubsequent(nodes, n));
	}

	@Test(expected = NodeValidatorException.class)
	public void shouldInvalidCycles() throws NodeValidatorException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("4444", "Description", "1111"));
		nodes.add(new Node("3333", "Description", "4444"));
		nodes.add(new Node("2222", "Description", "3333"));
		nodes.add(new Node("1111", "Description", "2222"));

		nv.validateMethod(nodes);
		boolean cycledGraph = (NodeValidatorException.exList.get(0) instanceof CycledGraphException);
		Assert.assertEquals(true, cycledGraph);
		fail("Expected a CycledGraphException to be thrown");
	}

	@Test
	public void shouldValidCycles() throws CycledGraphException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("4444", "Description", null));
		nodes.add(new Node("3333", "Description", "4444"));
		nodes.add(new Node("2222", "Description", "3333"));

		Assert.assertEquals(true, nv.validateCycles(nodes));
	}

	@Test
	public void shouldValidSubsequents() throws InvalidSubsequentException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("1234", "Description", "5678"));
		nodes.add(new Node("5678", "Description", "8901"));
		nodes.add(new Node("8901", "Description", null));

		Assert.assertEquals(true, nv.validateSubsequents(nodes));
	}

	@Test
	public void shouldValidSubsequents2() throws InvalidSubsequentException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("3333", "Description", null));
		nodes.add(new Node("4444", "Description", "3333"));
		nodes.add(new Node("5555", "Description", "4444"));
		nodes.add(new Node("6666", "Description", "4444"));

		Assert.assertEquals(true, nv.validateSubsequents(nodes));
	}

	@Test(expected = NodeValidatorException.class)
	public void shouldInvalidSubsequents() throws NodeValidatorException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("3333", "Description", null));
		nodes.add(new Node("4444", "Description", "3333"));
		nodes.add(new Node("5555", "Description", "4444"));
		nodes.add(new Node("6666", "Description", "4444"));
		nodes.add(new Node("7777", "Description", "4444"));
		nv.validateMethod(nodes);
		boolean invalidSub = (NodeValidatorException.exList.get(0) instanceof InvalidSubsequentException);
		Assert.assertEquals(true, invalidSub);
	}

	@Test(expected = NodeValidatorException.class)
	public void shouldInvalidSubsequents2() throws NodeValidatorException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();
		
		nodes.add(new Node("3333", "Description", null));
		nodes.add(new Node("4444", "Description", "3333"));
		nodes.add(new Node("5555", "Description", "4444"));
		nodes.add(new Node("6666", "Description", "4444"));
		nodes.add(new Node("7777", "Description", "3333"));
		nv.validateMethod(nodes);
		boolean invalidSub = (NodeValidatorException.exList.get(0) instanceof InvalidSubsequentException);
		Assert.assertEquals(true, invalidSub);
	}

	@Test(expected = NodeValidatorException.class)
	public void shouldInvalidSubsequents3() throws NodeValidatorException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();
		
		nodes.add(new Node("3333", "Description", null));
		nodes.add(new Node("4444", "Description", "3333"));
		nodes.add(new Node("5555", "Description", "4444"));
		nodes.add(new Node("6666", "Description", "4444"));
		nodes.add(new Node("7777", "Description", null));
		nodes.add(new Node("8888", "Description", "7777"));
		nodes.add(new Node("9999", "Description", "7777"));
		nv.validateMethod(nodes);
		boolean invalidSub = (NodeValidatorException.exList.get(0) instanceof InvalidSubsequentException);
		Assert.assertEquals(true, invalidSub);
	}

	@Test
	public void shouldValidNodes()
			throws CycledGraphException, InvalidDescriptionException, InvalidIDException, InvalidSubsequentException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("1234", "Description", "5678"));
		nodes.add(new Node("5678", "Description", "8901"));
		nodes.add(new Node("8901", "Description", null));

		Assert.assertEquals(true, nv.validateCycles(nodes));
	}

	@Test
	public void shouldInvalidNodes()
			throws CycledGraphException, InvalidDescriptionException, InvalidIDException, InvalidSubsequentException {
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("1234", "Description", "5678"));
		nodes.add(new Node("5678", "Description", "8901"));
		nodes.add(new Node("8901", "Description", null));

		Assert.assertEquals(true, nv.validateCycles(nodes));
	}

	@Test(expected = NodeValidatorException.class)
	public void shouldGiveAllExceptions() throws NodeValidatorException {
		boolean flag = false;
		NodeValidators nv = new NodeValidators();
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("11115",
				"Dekdhsfkjajhdfsjklfhdasjkfhdjksfhasdjklhfkljasdhfjkasdhfkljhasdfjk"
						+ "ashdfkljasdhfkljasdhfkldhfjkahflkhdkfjlhadjkfhjkhfjkldhfkajldhfkjhdsjkfh"
						+ "jklashfkjahsdkfjhasdkljfhkdjlsfhlksdhfscription",
				"5555"));
		nodes.add(new Node("2222", "Description", "11115"));
		nodes.add(new Node("3333", "Description", "3333"));
		nodes.add(new Node("4444", "Description", "3333"));
		nodes.add(new Node("5555", "Description", "3333"));

		nv.validateMethod(nodes);

		for (Exception ex : NodeValidatorException.exList) {
			if (ex instanceof InvalidIDException || ex instanceof InvalidDescriptionException
					|| ex instanceof InvalidSubsequentException || ex instanceof CycledGraphException)
				flag = true;
			if (!flag)
				break;
		}

		Assert.assertEquals(true, flag);
	}

}
