package com.baeldung.crud.repositories;

import com.baeldung.crud.entities.TutorAssignment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorAssignmentRepository extends CrudRepository<TutorAssignment, Long> {

}
