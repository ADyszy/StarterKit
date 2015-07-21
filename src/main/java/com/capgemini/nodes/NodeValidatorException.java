package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

public class NodeValidatorException extends Exception {
	
	private static final long serialVersionUID = 3545453508562004956L;

	public static List<Exception> exList = new ArrayList<Exception>(); 

	
	public static boolean occured() {
		return !exList.isEmpty();
	}
	
	public NodeValidatorException(){
		super(getMessageFromList());
		exList.clear();
	}

	
	public static String getMessageFromList(){
		String msg = "";
		for (Exception exception : exList) {
			msg += "\n" + exception.getMessage() ;
		}
		return msg;
	}
}




// private void bbb( argi z kropkami ...)