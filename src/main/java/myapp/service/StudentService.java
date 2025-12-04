package myapp.service;

import myapp.dto.StudentFullDTO;
import myapp.dto.StudentDTO;
import myapp.entity.Student;

import java.util.List;


public interface StudentService {

    List<StudentDTO> getAllStudents() ;
    StudentDTO getStudentById(Long id) ;
    StudentFullDTO getStudentFullVersion(Long id) ;
    void createStudent(StudentFullDTO studentFullDTO) ; ;
    void deleteStudent(Long id) ;
    void updateStudent( Long id , StudentFullDTO newStudent) ;
    boolean existsById (Long id) ;






//    private  final List<Student> studentsList = new ArrayList<>( ) ;
//
//    public List<Student> getAllStudents(){
//        return studentsList ;
//    }
//
//    public boolean containsThisId (Integer id){
//        return studentsList.stream().filter(student -> student.id.equals(id) ).count() == 1;
//    }
//
//    public Optional<Student> getStudentByid (Integer id) {
//        return  studentsList.stream().filter(student -> student.id == id).findFirst()  ;
//    }
//
//    public void addNewStudent ( Student newStudent) {
//        studentsList.add(newStudent) ;
//    }
//
//    public void deleteStudent (Integer id) {
////        studentsList.stream().filter(s->  s.id != id ) ;
//        studentsList.removeIf(s -> s.id == id) ;
//    }
//
//    public void updateStudentList (Student editetStudent){
//       studentsList.removeIf(s -> Objects.equals(s.id, editetStudent.id)) ;
//       studentsList.add(editetStudent) ;
//
//    }
}

