package myapp.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myapp.dto.MedicalFileDTO;
import myapp.service.MedicalFileService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/med-files")
public class MedicalFileController {

    @Autowired
    private MedicalFileService medFilesService ;
    @PostMapping("")
    public ResponseEntity<String> createMedFile (MedicalFileDTO mfDTO) {
        medFilesService.createMedicalPaper(mfDTO);
        return new ResponseEntity<>("Medical Created !!" , HttpStatus.CREATED) ;
    }

}
