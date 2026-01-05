package myapp.service;

import java.util.List;

import myapp.dto.MedicalFileDTO;

public interface MedicalFileService {
    void createMedicalPaper(MedicalFileDTO MFDTO , Long id) ;
    // List<MedicalFileDTO> getAlltMedicalFiles( ) ;
    // void deleteMedicalPaper (Long id) ;
    List<MedicalFileDTO> getAllMedicalFilesById(Long StudentId) ;
    // MedicalFileDTO getOneMedicalFileById(Long id) ;
    // void updateMedicalFile(Long id , MedicalFileDTO newMedicalFileDTO) ;


}
