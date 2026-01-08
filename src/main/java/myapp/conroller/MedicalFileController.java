package myapp.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myapp.dto.MedicalFileDTO;
import myapp.repository.MedicalFileRep;
import myapp.service.MedicalFileService;


@RestController
// @CrossOrigin("http://localhost:3000")
@RequestMapping("/api/med-files")
public class MedicalFileController {

    @Autowired
    private MedicalFileService medFilesService ;
    @Autowired
    private MedicalFileRep medRep ;


    @PostMapping("/{id}")
    public ResponseEntity<String> createMedFile ( @PathVariable Long id , @RequestBody MedicalFileDTO mfDTO  ) {
        medFilesService.createMedicalPaper(mfDTO , id);
        return new ResponseEntity<>("Medical Created !!" , HttpStatus.CREATED) ;
    }

    @GetMapping("")
    public List<MedicalFileDTO> getAllMedicalFiles  () {
        return medFilesService.getAlltMedicalFiles() ;
        
    }

    @GetMapping("/{id}")
    public MedicalFileDTO getMedicalFile  (@PathVariable Long id) {
        return medFilesService.getOneMedicalFileById(id) ;
        
    }

    @GetMapping("/student/{id}")
    public List<MedicalFileDTO> getAllMedicalFilesById  (@PathVariable Long id) {
        return medFilesService.getAllMedicalFilesById(id) ;
        // return medRep.findByStudentId(id) ;
        
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteMedicalFile (@PathVariable Long id) {
        medFilesService.deleteMedicalPaper(id);
        return new ResponseEntity<>("Medical File Deleted !!" , HttpStatus.OK) ;

    } 


    @PutMapping("/{id}")
    public ResponseEntity<String>  updateMedicalFile (@PathVariable Long id , @RequestBody MedicalFileDTO newMFDTO) {
        medFilesService.updateMedicalFile(id, newMFDTO);
        return new ResponseEntity<>("Medical File Updated !!" , HttpStatus.OK) ;

    } 





    
    

}
