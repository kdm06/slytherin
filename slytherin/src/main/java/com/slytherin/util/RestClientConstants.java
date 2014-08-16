package com.slytherin.util;

public class RestClientConstants {
	public static final String GET_USER_URL = "http://192.168.1.103:8080/slytherin-isigaw/user/";
	public static final String CREATE_USER_URL = "http://192.168.1.103:8080/slytherin-isigaw/user";
	public static final String GET_LIST_CRIMES = "";
	
	//User Type
	public static final String TYPE_CITIZEN = "CITIZEN";
	public static final String TYPE_LAW = "LAW_ENFORCEMENT";
	public static final String TYPE_GOV = "GOV_ENTITY";
	
	//User Role
	public static final String MEMBER_ADMIN = "ADMIN";
	public static final String MEMBER_ANONYMOUS = "ANONYMOUS";
	public static final String MEMBER_REGISTERED = "REGISTERED_USER";
	
	//Statis
	public static final String MEMBER_ENABLED = "ENABLED";
	
	public static final String YES = "Y";
	public static final String NO = "N";
	
	//Rest response
	public static final int STATUS_PASSWORD = 400;
	public static final int STATUS_OK = 200;
}
