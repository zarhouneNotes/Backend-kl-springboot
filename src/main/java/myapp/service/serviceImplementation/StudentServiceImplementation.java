package myapp.service.serviceImplementation;

import myapp.dto.StudentFullDTO;
import myapp.dto.ParentDTO;
import myapp.dto.StudentDTO;
import myapp.entity.Parent;
import myapp.entity.Person;
import myapp.entity.Student;
import myapp.exeption.BadRequestExeption;
import myapp.repository.ParentRep;
import myapp.repository.StudentRep;
import myapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private  StudentRep studentRepo ;
    @Autowired
    private ParentRep parentRep ;


    @Override
    public List<StudentDTO> getAllStudents(){
        try {
            return studentRepo.findAll()
                    .stream()
                    .map(this::toStudentDTO)
                    .collect(Collectors
                            .toList()) ;
        }catch (Exception e){
            throw new BadRequestExeption("Something went wrong");
        }
    }

    @Override
    public StudentDTO getStudentById(Long id){
        try{
            Student st = studentRepo.findById(id).orElseThrow(()->new BadRequestExeption("Student not found")) ;
            return toStudentDTO(st)  ;

        }catch (Exception ignored){
            throw new BadRequestExeption("Something went wrong") ;
        }
    }

    @Override
    public StudentFullDTO getStudentFullVersion(Long id){
        try{
            Student st = studentRepo.findById(id)
                    .orElseThrow(()-> new BadRequestExeption("Student not found or invalid id")) ;



            if (st.getFather().getId() == null || st.getMother().getId() == null)
                throw  new BadRequestExeption("Parent not found or invalid id") ;

            Parent father = parentRep.findById(st.getFather().getId()).orElse(null);
            Parent mother = parentRep.findById(st.getMother().getId()).orElse(null) ;

            return toStudentFullDTO(st,father,mother) ;


        }catch (Exception ignored){
            throw new BadRequestExeption("Something went wrong") ;
        }
    }
    @Override
    public void createStudent(StudentFullDTO studentFullDTO){
        if (studentFullDTO == null ||
                studentFullDTO.getStudent() == null ||
                studentFullDTO.getFather() == null ||
                studentFullDTO.getMother() == null
        ){
            throw new BadRequestExeption("Bad request : missing data");
        }
        Student student = toStudentEntity(studentFullDTO.getStudent()) ;
        Parent father = toParentEntity(studentFullDTO.getFather()) ;
        Parent mother = toParentEntity(studentFullDTO.getMother()) ;

        try {
            //    // save parents first to have IDs
            father = parentRep.save(father) ;
            mother = parentRep.save(mother) ;
//
//    // set student parents
            student.setFather(father);
            student.setMother(mother);

            studentRepo.save(student) ;
        }catch (Exception e){
            throw new BadRequestExeption("Bad request : Failed to save data!") ;
        }






    }




    @Override
    public void deleteStudent (Long id){
        try{
            studentRepo.deleteById(id);
        }catch (Exception e){
            throw new BadRequestExeption("Something went wrong") ;
        }
    }

    @Override
    public void updateStudent(Long id , StudentFullDTO newStudentVersioDTO){

        if (newStudentVersioDTO == null) throw new BadRequestExeption("Bad request : missing data");

        try{
            Student student = toStudentEntity(newStudentVersioDTO.getStudent()) ;
            Parent father = toParentEntity(newStudentVersioDTO.getFather()) ;
            Parent mother = toParentEntity(newStudentVersioDTO.getMother()) ;
            father = parentRep.save(father) ;
            mother =  parentRep.save(mother) ;


            student.setFather(father);
            student.setMother(mother);

            studentRepo.save(student) ;
        }catch (Exception e){
            throw new BadRequestExeption("Bad request : Failed to save data!") ;
        }



    }

    @Override
    public boolean existsById(Long id){
        return studentRepo.existsById(id) ;
    }


    // convert    ENTITY --->> DTO

    public StudentDTO toStudentDTO (Student student ){
        StudentDTO studentDTO = new StudentDTO() ;
        studentDTO.setId(student.getId());
        studentDTO.setFirstname(student.getFirstname());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setBirthdate(student.getBirthDate().toString());
        studentDTO.setGender(student.getGender().toString());
        studentDTO.setSection(student.getSection().toString());
//        studentDTO.setFather_id(student.getFather().getId().toString());
//        studentDTO.setMother_id(student.getMother().getId().toString());
        studentDTO.setPhoto(student.getPhoto());
        return studentDTO ;
    }




    public ParentDTO toParentDTO (Parent parent){
        ParentDTO parentDTO = new ParentDTO() ;
        parentDTO.setId(parent.getId());
        parentDTO.setCin(parent.getCin());
        parentDTO.setFirstname(parent.getFirstname());
        parentDTO.setLastname(parent.getLastname());
        parentDTO.setGender(parent.getGender().toString());
        parentDTO.setIdentity(parent.getIdentity());
        parentDTO.setPhone(parent.getPhone());
        return parentDTO ;
    }


    // DTO -->>> ENTITYY

    public Student toStudentEntity (StudentDTO studentDTO){
        Student student = new Student() ;
        student.setFirstname(studentDTO.getFirstname());
        student.setLastname(studentDTO.getLastname());
        student.setStringToGender(studentDTO.getGender());
        student.setBirthDate(LocalDate.parse(studentDTO.getBirthdate() , DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        student.setStringToSection(studentDTO.getSection());
        student.setPhoto(studentDTO.getPhoto());
        return student;
    }



    public Parent toParentEntity (ParentDTO parentDTO){
        Parent parent = new Parent() ;
        parent.setId(parentDTO.getId());
        parent.setCin(parentDTO.getCin());
        parent.setFirstname(parentDTO.getFirstname());
        parent.setLastname(parentDTO.getLastname());
        parent.setIdentity(parentDTO.getIdentity());
        parent.setPhone(parentDTO.getPhone());
        parent.setStringToGender(parentDTO.getGender());

        return parent ;
    }



    // KID + PARENTS --->  TO FAMILLYDTO

    public StudentFullDTO toStudentFullDTO (Student student , Parent father , Parent mother){
        StudentFullDTO studentFullDTO = new StudentFullDTO() ;
        studentFullDTO.setFather(toParentDTO(father));
        studentFullDTO.setMother(toParentDTO(mother));
        studentFullDTO.setStudent(toStudentDTO(student));
        return studentFullDTO;
    }






}


