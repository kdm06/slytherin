package com.slytherin.util;

public class Misc {
	public static boolean isNotEmpty(Object obj){
		return obj != null;
	}
	
	public static boolean isEmpty(Object obj){
		return !isNotEmpty(obj);
	}
	
	public static boolean ifNotEmpty(String strValue) {
	    return (strValue!=null && strValue.trim().length() > 0);
	}
	
	public static boolean ifEmpty(String strValue) {
	    return !(ifNotEmpty(strValue));
	}
}
