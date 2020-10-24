package com.maartenmusic.petclinic.repositories;

import com.maartenmusic.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
