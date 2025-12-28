package myapp.service.serviceImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.dto.MedicalFileDTO;
import myapp.entity.MedicalFile;
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
    public void createMedicalPaper (MedicalFileDTO MFDTO){
        if(MFDTO == null ) throw new BadRequestExeption("MISSING_DATA") ; 
        try {

            // Student st = studentRep.findById(MFDTO.getStudent_id()).orElseThrow(()-> new BadRequestExeption("Student not found / invalid id")) ;
            MedicalFile mf = toMedicalEntity(MFDTO);
            // mf.setStudent(st);
            medicalFileRep.save(mf) ;
            
        } catch (Exception e) {
            e.printStackTrace() ;
            throw new BadRequestExeption("Failed to fatch "+e.getCause() ) ;
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




}
