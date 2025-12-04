package myapp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

import java.time.LocalDate;

@Entity
public class Teacher extends Person{
    private String cin ;
    private Integer phone ;
    @Lob
    private byte[] identity ;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate hiredate ;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate endDate ;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public byte[] getIdentity() {
        return identity;
    }

    public void setIdentity(byte[] identity) {
        this.identity = identity;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }
    public void setHiredate(LocalDate hire_date) {
        this.hiredate = hire_date;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


}
