package myapp.service;

import java.util.List;

import myapp.dto.TeacherDTO;


public interface TeacherServiceInterface {
    
    List<TeacherDTO> getTeachers() ;
    TeacherDTO getTeacherById(Long id) ; 
    void deleteTeacher(Long id)  ;
    void  updateTeacher (Long id , TeacherDTO teacher) ;
    void createTeacher (TeacherDTO teacher) ;
 
}
