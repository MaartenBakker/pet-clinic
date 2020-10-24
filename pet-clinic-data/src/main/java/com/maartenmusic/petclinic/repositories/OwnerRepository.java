package com.maartenmusic.petclinic.repositories;

import com.maartenmusic.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
