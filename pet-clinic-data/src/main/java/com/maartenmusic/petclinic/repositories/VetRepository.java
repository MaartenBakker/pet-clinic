package com.maartenmusic.petclinic.repositories;

import com.maartenmusic.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
