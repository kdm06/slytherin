package com.slytherin.util;

public class RestClientConstants {
	public static final String IP_ADDRESS = "http://192.168.1.101:8080/";
	public static final String GET_USER_URL = "slytherin-isigaw/user/";
	public static final String CREATE_USER_URL = "slytherin-isigaw/user";
	public static final String CREATE_CRIME = "slytherin-isigaw/crime";
	public static final String GET_LIST_CRIMES = "slytherin-isigaw/crime/load";
	public static final String GET_CRIME_BY_ID = "slytherin-isigaw/crime/";
	public static final String REPORT_MONTH_TYPE = "slytherin-isigaw/crime/report/";
	
	//User Type
	public static final String TYPE_CITIZEN = "CITIZEN";
	public static final String TYPE_LAW = "LAW_ENFORCEMENT";
	public static final String TYPE_GOV = "GOV_ENTITY";
	
	//User Role
	public static final String MEMBER_ADMIN = "ADMIN";
	public static final String MEMBER_ANONYMOUS = "ANONYMOUS";
	public static final String MEMBER_REGISTERED = "REGISTERED_USER";
	
	//Status
	public static final String MEMBER_ENABLED = "ENABLED";
	
	public static final String YES = "Y";
	public static final String NO = "N";
	
	//Rest response
	public static final int STATUS_PASSWORD = 400;
	public static final int STATUS_OK = 200;
	
	public static final String[] CRIME_TYPE = {"PROSTITUTION", "THEFT", "MURDER", "KIDNAPPING", "ARSON", "RAPE", "PATRICIDE", "MATRICIDE", "HOMICIDE", "SUICIDE", "OTHER"}; 
}
