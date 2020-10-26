package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.Pet;
import com.maartenmusic.petclinic.repositories.PetRepository;
import com.maartenmusic.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Profile("springdatajpa")
public class PetSDJpaService extends AbstractSDJpaService<Pet, PetRepository>
        implements PetService {

    public PetSDJpaService(PetRepository repository) {
        super(repository);
    }
}
