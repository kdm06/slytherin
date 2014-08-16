/**
 * 
 */
package com.slytherin.dto;


public class IdentityConstants {
    
    /********IDENTITY STATUS***********/
    public static final String STATUS_ENABLED = "ENABLED";
    public static final String STATUS_DISABLED = "DISABLED";

    /********ERROR MESSAGES***********/
    public static final String IDENTITY_NOT_FOUND = "Identity not found";
    public static final String IDENTITY_DIFFERENT_TYPE = "Different identity type";
    public static final String IDENTITY_INEXISTENT = "Identity does not exist";
    public static final String IDENTITY_DISABLED= "Identity already disabled";
    public static final String IDENTITY_ENABLED= "Identity already enabled";
    
    public static final String INVALID_REQUEST = "Invalid request";
    
    
    
    
    private IdentityConstants() {
        //Should not be able to instaintate constants object
    }
    
}
