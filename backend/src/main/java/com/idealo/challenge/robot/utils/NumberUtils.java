package com.idealo.challenge.robot.utils;

public class NumberUtils {
	
	public static int getNumber(String strNum) {
	    if (strNum == null) {
	        return -1;
	    }
	    try {
	        return Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return -1;
	    }
	}
}
