package com.slytherin.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class UserDTO extends IdentityDTO {

    private String firstName;

    private String lastName;
    
    @Pattern(regexp="CITIZEN|LAW_ENFORCEMENT|GOV_ENTITY", message="User Type value can only be 'CITIZEN' or 'LAW_ENFORCEMENT' or 'GOV_ENTITY', .")
    private String userType;
    
    @Pattern(regexp="ADMIN|ANONYMOUS|REGISTERED_USER", message="User role value can only be 'ADMIN' or 'ANONYMOUS' or 'REGISTERED_USER', .")
    private String userRole;
    
    @Pattern(regexp="ENABLED|DISABLED", message="Status value can only be 'ENABLED' or 'DISABLED'.")
    private String status;
    
    @NotBlank(message="User Name must have a value!")
    private String userName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
