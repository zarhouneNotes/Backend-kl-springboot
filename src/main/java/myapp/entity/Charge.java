package myapp.entity;


import jakarta.persistence.Entity;

@Entity
public class Charge extends  Transaction {
    private Integer amount ;
    private String reason ;

    //getters

    public Integer getAmount() {
        return amount ;
    }

    public String getReason() {
        return reason;
    }


    //setters


    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
