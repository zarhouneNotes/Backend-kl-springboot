package myapp.service.serviceImplementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myapp.dto.TeacherDTO;
import myapp.entity.Teacher;
import myapp.exeption.BadRequestExeption;
import myapp.repository.TeacherRep;
import myapp.service.TeacherServiceInterface;

@Service
public class TeacherServiceImplementation implements TeacherServiceInterface  {

    @Autowired
    private TeacherRep teacherRep ;

    @Override
    public List<TeacherDTO> getTeachers(){
        try {
        return teacherRep.findAll().stream().map(this::toTeacherDTO).toList() ;
            
        } catch (Exception e) {
            throw new BadRequestExeption("Bad request : something went wrong ") ;
        }

    }

    @Override
    public TeacherDTO getTeacherById (Long id){
        Teacher t = teacherRep.findById(id).orElseThrow(()-> new BadRequestExeption("Bad request : Teacher not found or invalid ID!"));
        return toTeacherDTO(t) ;
    }

    @Override 
    public void createTeacher (TeacherDTO teacher) {
        if(teacher == null) 
            throw new BadRequestExeption("Bad request : missing data !") ;
        try{
            teacherRep.save(toTeacherEntity(teacher)) ;
        }catch(Exception e){
            throw  new BadRequestExeption("Bad request or missing data") ;
        }
    }


    @Override
    public void updateTeacher (Long id , TeacherDTO newTeacher) {
            
            try {
                if(newTeacher == null) 
                    throw new BadRequestException("Bad request : missing data") ;

                Teacher exiTeacher = teacherRep.findById(id).orElseThrow(()-> new BadRequestExeption("Bad request : Teacher not found or invalid id")) ;
                updTeacherEntity(exiTeacher, toTeacherEntity(newTeacher));
                teacherRep.save(exiTeacher) ;
            } catch (Exception e) {
                e.printStackTrace();
                throw new BadRequestExeption("Bad request : Failed to update data!" + e.getCause()) ;
             }
    }

    @Override
    public  void deleteTeacher (Long id)  {
                try {
                    
                    teacherRep.deleteById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new BadRequestExeption("Bad request : Failed to update data!" + e.getCause()) ;
                 }
    
    }




    //// DTO <-> ENTITY

    public Teacher toTeacherEntity (TeacherDTO teacherdto) {
        Teacher teacher = new Teacher() ;
        teacher.setFirstname(teacherdto.getFirstname());
        teacher.setLastname(teacherdto.getLastname());
        teacher.setStringToGender(teacherdto.getGender());
        teacher.setCin(teacherdto.getCin());
        teacher.setIdentity(teacherdto.getIdentity());
        teacher.setPhone(teacherdto.getPhone());
        teacher.setHiredate(LocalDate.parse(teacherdto.getHiredate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        teacher.setEndDate(LocalDate.parse(teacherdto.getEnddate() , DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        return teacher ;
    }
    

    /// 
    /// 
    /// ENTITY <-> DTO
     
    public TeacherDTO toTeacherDTO (Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO() ;
        teacherDTO.setId(teacher.getId().toString());
        teacherDTO.setFirstname(teacher.getFirstname());
        teacherDTO.setLastname(teacher.getLastname());
        teacherDTO.setGender(teacher.getGender().toString());
        teacherDTO.setCin(teacher.getCin());
        teacherDTO.setIdentity(teacher.getIdentity());
        teacherDTO.setPhone(teacher.getPhone());
        teacherDTO.setHiredate(teacher.getHiredate().toString());
        teacherDTO.setEnddate(teacher.getEndDate().toString());
        return teacherDTO ;

        //// update teacher <-> teacher
        
        
    }

    public void updTeacherEntity (Teacher exiTeacher , Teacher newTeacher){

        exiTeacher.setFirstname(newTeacher.getFirstname());
        exiTeacher.setLastname(newTeacher.getLastname());
        exiTeacher.setGender(newTeacher.getGender());
        exiTeacher.setCin(newTeacher.getCin());
        exiTeacher.setIdentity(newTeacher.getIdentity());
        exiTeacher.setPhone(newTeacher.getPhone());
        exiTeacher.setHiredate(newTeacher.getHiredate());
        exiTeacher.setEndDate(newTeacher.getEndDate());
            
    }
    
}
