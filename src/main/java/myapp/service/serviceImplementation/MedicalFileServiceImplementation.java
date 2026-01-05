package myapp.service.serviceImplementation;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.dto.MedicalFileDTO;
import myapp.entity.MedicalFile;
import myapp.entity.Student;
import myapp.exeption.BadRequestExeption;
import myapp.repository.MedicalFileRep;
import myapp.repository.StudentRep;
import myapp.service.MedicalFileService;

@Service
public class MedicalFileServiceImplementation implements MedicalFileService{
    @Autowired
    private MedicalFileRep medicalFileRep ;
    @Autowired
    private StudentRep studentRep ;


    @Override
    public void createMedicalPaper(MedicalFileDTO MFDTO , Long id) {
    
        if (MFDTO == null) {
            throw new BadRequestExeption("MISSING_DATA");
        }
        
        Student student = studentRep.findById(id).orElseThrow(()-> new BadRequestExeption("STUDENT NOT FOUND OR INVALID ID ") ) ;
        MedicalFile mf = toMedicalEntity(MFDTO) ; 
        mf.setStudent(student);
        medicalFileRep.save(mf) ;

    
    }


    @Override
    public List<MedicalFileDTO> getAllMedicalFilesById(Long StudentId)  {

        try {
            List <MedicalFile> med_Files = medicalFileRep.findAll() ;
            return med_Files.stream().map(this::toMedicalDTO).collect(Collectors.toList()) ;
        } catch (Exception e){
            throw new BadRequestExeption("Something went wrong");
        }

    }
    

    // @Override 
    // public void updateMedicalFile(Long id , MedicalFileDTO NewMFDTO){

    // }

    // @Override 
    // public MedicalFileDTO getOneMedicalFileById(Long id){

    // }




    // DTO --> ENTITY

    public MedicalFile toMedicalEntity(MedicalFileDTO medicalFileDTO){
        MedicalFile mf = new MedicalFile() ;
        mf.setPaper(medicalFileDTO.getPaper());
        mf.setPaperType(medicalFileDTO.getPaperType()) ;
       
        
        return mf ;
    }


    public MedicalFileDTO toMedicalDTO(MedicalFile md_entity){
        MedicalFileDTO mf = new MedicalFileDTO() ;
        mf.setPaper(md_entity.getPaper());
        mf.setPaperType(md_entity.getPaperType());
        mf.setId(md_entity.getId().toString());
        
        return mf ;
    }







}
