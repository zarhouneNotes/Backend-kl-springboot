package myapp.service;

import java.util.List;

import myapp.dto.MedicalFileDTO;

public interface MedicalFileService {
    void createMedicalPaper(MedicalFileDTO MFDTO , Long id) ;
    List<MedicalFileDTO> getAllMedicalFilesById(Long id) ;
    List<MedicalFileDTO> getAlltMedicalFiles( ) ;
    MedicalFileDTO getOneMedicalFileById(Long id) ;
    void deleteMedicalPaper (Long id) ;
    void updateMedicalFile(Long id , MedicalFileDTO newMedicalFileDTO) ;


}
