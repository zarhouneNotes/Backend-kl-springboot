package myapp.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class MediaFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Student student ;

    @Lob
    private byte[] paper ;
    private String paperType;

    //getters


    public Long getId() {
        return id;
    }

    public String getPaperType() {
        return paperType ;
    }

    public Student getStudent(){
        return student ;
    }


    // setters


    public void setPaperType (String paperType){
        this.paperType = paperType ;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
