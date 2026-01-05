package myapp.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myapp.dto.MedicalFileDTO;
import myapp.service.MedicalFileService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myapp.entity.MedicalFile;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/med-files")
public class MedicalFileController {

    @Autowired
    private MedicalFileService medFilesService ;


    @PostMapping("/{id}")
    public ResponseEntity<String> createMedFile ( @PathVariable Long id , @RequestBody MedicalFileDTO mfDTO  ) {
        medFilesService.createMedicalPaper(mfDTO , id);
        return new ResponseEntity<>("Medical Created !!" , HttpStatus.CREATED) ;
    }

    @GetMapping("/medical_files/{id}")
    public List<MedicalFileDTO> (Long id) {
        return medFilesService.getAllMedicalFilesById(id) ;
    }

    
    

}
