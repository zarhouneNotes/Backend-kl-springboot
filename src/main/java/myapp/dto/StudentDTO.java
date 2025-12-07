package myapp.dto;

public class StudentDTO {
    private Long id ;
    private String firstname ;
    private String lastname ;
    private String birthdate ;
    private String gender ;
    private String section ;
    private String photo ;


    // getters


    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate(){
        return birthdate ;
    }

    public String getGender() {
        return gender ;
    }

    public String getSection() {
        return section;
    }


    public String getPhoto() {
        return photo;}



    // setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(String gender) {
        this.gender = gender; }

    public void setSection(String section) {
        this.section = section;
    }


    public void setPhoto(String photo){
        this.photo = photo ;
    }






}

