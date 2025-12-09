package myapp.conroller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import myapp.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class FilesController {
    @Autowired
    private  StudentService studentService ;

     @PostMapping("/upload/{path}")
    public ResponseEntity<String> uploadFile (@RequestParam MultipartFile file , @PathVariable String path) throws IOException {
        
         String URL = this.saveFile(file , path ) ;
         return new ResponseEntity<>(URL  , HttpStatus.CREATED) ;

    }




     public String saveFile (MultipartFile myFile , String path ) throws IOException { 

            String uploadsDir = "uploads/"+path;
            Path dirPath = Paths.get(uploadsDir) ;
            Files.createDirectories(dirPath)  ;
            // get ext
            String fn = myFile.getOriginalFilename() ;
            String Ext = "" ;
            if (myFile != null && fn.contains(".")) {
                Ext = fn.substring(fn.lastIndexOf(".")) ;
                
            }


            String filename = "student_"+UUID.randomUUID()+Ext ;
            Path filePath = dirPath.resolve(filename) ;
            Files.write(filePath, myFile.getBytes()) ;
            return uploadsDir+"/"+ filename ;
        
       
    }
}
