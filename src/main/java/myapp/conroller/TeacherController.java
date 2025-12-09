package myapp.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myapp.dto.TeacherDTO;
import myapp.service.TeacherServiceInterface;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherServiceInterface teacherService ;

    @GetMapping("")
    public List<TeacherDTO> getTeachers (){
        return teacherService.getTeachers() ;
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id){
        return teacherService.getTeacherById(id) ;
    }

    @PostMapping("")
    public ResponseEntity<String> createTeacher (@RequestBody TeacherDTO teacherDTO){
        teacherService.createTeacher(teacherDTO);
        return new ResponseEntity<>("Teacher created successfully" , HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTeacher ( @PathVariable Long id , @RequestBody TeacherDTO teacherDTO){
        teacherService.updateTeacher(id, teacherDTO);
        return new ResponseEntity<>("Teacher updated successfully" , HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher ( @PathVariable Long id ){
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>("Teacher deleted successfully" , HttpStatus.CREATED) ;
    }
    
}
