package com.maartenmusic.petclinic.repositories;

import com.maartenmusic.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
