package myapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Student extends Person  {
    public enum Section {MS , PS , GS }

    @Enumerated(EnumType.STRING)
    private Section section ;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate ;
    private String season ;
    @Lob
    private byte[] photo ;

    @ManyToOne
    @JoinColumn
    private Parent father ;

    @ManyToOne ()
    @JoinColumn
    private Parent mother ;





    //getters



    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Section getSection() {
        return section;
    }

    public Parent getFather() {
        return father;
    }
    public Parent getMother(){
         return mother ;
    }

    public byte[] getPhoto() {
        return photo;
    }


    //


    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setStringToSection(String section) {
        switch (section.toUpperCase()) {
            case "GS" ->  this.section = Section.GS;
            case "MS" -> this.section = Section.MS;
            case "PS" -> this.section = Section.PS;
        }
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
