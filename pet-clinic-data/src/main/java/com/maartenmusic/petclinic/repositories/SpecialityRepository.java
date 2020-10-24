package com.maartenmusic.petclinic.repositories;

import com.maartenmusic.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
