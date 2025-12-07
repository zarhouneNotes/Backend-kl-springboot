package myapp.entity;

import jakarta.persistence.*;

@Entity
public class Parent extends Person{

    private String cin ;
    private String phone ;
    @Lob
    private String identity ;

    // getters


    public String getPhone() {
        return phone;
    }
    public  String getIdentity() {
        return identity ;
    }

    public String getCin (){
        return cin ;
    }

    // setters


    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
