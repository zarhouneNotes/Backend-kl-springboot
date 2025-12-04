package myapp.repository;

import myapp.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRep extends JpaRepository<Parent , Long> {
}
