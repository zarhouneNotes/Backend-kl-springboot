package myapp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

import java.time.LocalDate;

@Entity
public class Teacher extends Person{
    private String cin ;
    private String phone ;
    @Lob
    private String identity ;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate hiredate ;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate ;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
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
