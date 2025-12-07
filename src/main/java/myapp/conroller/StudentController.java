package myapp.conroller;
import myapp.dto.StudentFullDTO;
import myapp.dto.StudentDTO;
import myapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping ("/api/students")

public class StudentController {
    @Autowired
    private StudentService studentService ;


    @GetMapping("")
    public List<StudentDTO> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById (@PathVariable Long id) {
        return studentService.getStudentById(id) ;
    }

    @GetMapping("/full/{id}")
    public StudentFullDTO getStudentFullById (@PathVariable Long id) {
        return studentService.getStudentFullVersion(id);
    }


    @PostMapping("")
    public ResponseEntity<String> addStudent ( @RequestBody StudentFullDTO studentFullDTO) {
        studentService.createStudent(studentFullDTO);
        return new ResponseEntity<>("Student added successfully" , HttpStatus.CREATED  ) ;
    }

   


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student Deleted successfully" , HttpStatus.OK)  ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent (@PathVariable Long id , @RequestBody StudentFullDTO studentFullDTO){

        studentService.updateStudent(id, studentFullDTO);

        return new ResponseEntity<>("Student updated ;)" , HttpStatus.OK) ;

    }

}
