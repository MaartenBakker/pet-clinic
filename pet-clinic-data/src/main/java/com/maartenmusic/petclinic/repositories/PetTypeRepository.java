package com.maartenmusic.petclinic.repositories;

import com.maartenmusic.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
