package com.baeldung.crud.repositories;

import com.baeldung.crud.entities.Tutor;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends CrudRepository<Tutor, Long> {
    
   // List<Tutor> findByFname(String fname);
    
}
