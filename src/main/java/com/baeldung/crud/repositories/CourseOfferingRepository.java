package com.baeldung.crud.repositories;

import com.baeldung.crud.entities.CourseOffering;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends CrudRepository<CourseOffering, Long> {
      // List<CourseOffering> findByQuarter(String quarter);
}
