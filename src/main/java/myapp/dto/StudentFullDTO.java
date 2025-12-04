package myapp.dto;

public class StudentFullDTO {
    private StudentDTO student ;
    private ParentDTO father ;
    private ParentDTO mother ;

    public ParentDTO getMother() {
        return mother;
    }

    public void setMother(ParentDTO mother) {
        this.mother = mother;
    }

    public ParentDTO getFather() {
        return father;
    }

    public void setFather(ParentDTO father) {
        this.father = father;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
