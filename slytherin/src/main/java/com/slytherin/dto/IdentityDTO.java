package com.slytherin.dto;


public class IdentityDTO {

    private String id;
    
    private String status;
    
    private String password;
    
    public IdentityDTO() {
        this.status = IdentityConstants.STATUS_ENABLED;
    }
    
    public IdentityDTO(String id) {
        this();
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("DTO of type %s with id %s", this.getClass().getName(), getId());
    }
}
