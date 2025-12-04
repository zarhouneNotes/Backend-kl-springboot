package myapp.entity;

import jakarta.persistence.Entity;

@Entity
public class DailyIncome extends Transaction{
    private Integer amount ;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
