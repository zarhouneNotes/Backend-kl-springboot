package myapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;


@MappedSuperclass
public abstract class Transaction {
    @Id
    private Long id ;
    @JsonFormat(pattern = "dd-mm-yyy")
    private LocalDate t_date ;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getT_date() {
        return t_date;
    }

    public void setT_date(LocalDate t_date) {
        this.t_date = t_date;
    }
}
