package com.slytherin.dto;

import javax.validation.constraints.Pattern;

public class AddressDTO {
    private String id;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zip;
    @Pattern(regexp="USER_LOCATION|CRIME_LOCATION", message="Address type value can only be 'USER_LOCATION' or 'CRIME_LOCATION'.")
    private String addressType;
    
    public AddressDTO() {
    }
 
    public AddressDTO(final String sa1, final String sa2, final String city,
            final String state, final String zip, String addressType) {
        setStreetAddress1(sa1);
        setStreetAddress2(sa2);
        setCity(city);
        setState(state);
        setZip(zip);
        setAddressType(addressType);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStreetAddress1() {
        return streetAddress1;
    }
    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }
    public String getStreetAddress2() {
        return streetAddress2;
    }
    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getAddressType() {
        return addressType;
    }
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    
    
}
