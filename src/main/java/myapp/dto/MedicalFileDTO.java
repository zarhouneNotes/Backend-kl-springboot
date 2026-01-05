package myapp.dto;

public class MedicalFileDTO {
    private String id ;
    private String paper ;
    private String paperType ;
    // private Long student_id ;

    


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    // public Long getStudent_id() {
    //     return student_id;
    // }

    // public void setStudent_id(Long student_id) {
    //     this.student_id = student_id;
    // }

}
