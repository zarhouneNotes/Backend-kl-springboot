package myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myapp.entity.MedicalFile;

@Repository
public interface MedicalFileRep extends JpaRepository<MedicalFile , Long> {
    
}
