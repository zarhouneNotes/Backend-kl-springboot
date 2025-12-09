package myapp.repository;

import myapp.dto.StudentFullDTO;
import myapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRep extends JpaRepository <Student , Long> {

//    @Query(
//            value = """
//        SELECT s.*, father.firstname AS fatherName, mother.firstname AS motherName
//        FROM student s
//        JOIN parent father ON s.father_id = father.id
//        JOIN parent mother ON s.mother_id = mother.id
//        WHERE s.id = :id
//    """,
//            nativeQuery = true
//    )
//    public Student getStudentFullVersionById(@Param("id") Long id) ;

}
