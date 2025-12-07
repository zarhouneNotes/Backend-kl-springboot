package myapp.conroller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import myapp.service.StudentService;

@RestController
public class FilesController {
    @Autowired
    private  StudentService studentService ;

     @PostMapping("/upload")
    public ResponseEntity<String> uploadFile (@RequestParam MultipartFile file) throws IOException {
        
          studentService.saveFile(file) ;
         return new ResponseEntity<>( HttpStatus.CREATED) ;

    }
}
