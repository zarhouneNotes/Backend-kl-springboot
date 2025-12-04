package myapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String firstname ;
    private String lastname ;
    public enum Gender  { MALE , FEMALE} ;
    @Enumerated(EnumType.STRING)
    private Gender gender ;






    // getters

    public String getFirstname(){
        return firstname ;
    }

    public String getLastname(){
        return lastname ;
    }

    public Gender getGender(){
        return gender ;
    }

    public Long getId() {
        return id;
    }

    // setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname (String fs) {
        this.firstname = fs ;
    }


    public void setLastname (String ls ) {
        this.lastname = ls ;
    }

    public void  setGender (Gender gender) {
        this.gender = gender ;
    }

    public void setStringToGender (String gender){
        if(gender.equalsIgnoreCase("MALE")) {
            this.gender = Gender.MALE ;
        } else if(gender.equalsIgnoreCase("FEMALE")) {
            this.gender = Gender.FEMALE ;
        }
    }
}
