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
}
