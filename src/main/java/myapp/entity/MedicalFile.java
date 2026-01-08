package myapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class MedicalFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student ;

    @Lob
    private String paper ;
    private String paperType;

    //getters

    public String getPaper (){
        return this.paper ;
    }


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
    public void setId(Long id){
        this.id = id ;
    }

    public void setPaperType (String paperType){
        this.paperType = paperType ;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }
}
