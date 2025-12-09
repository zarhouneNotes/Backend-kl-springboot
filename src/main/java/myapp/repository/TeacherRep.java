package myapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import myapp.entity.Teacher;



@Repository
public interface  TeacherRep extends JpaRepository<Teacher , Long> {

}
