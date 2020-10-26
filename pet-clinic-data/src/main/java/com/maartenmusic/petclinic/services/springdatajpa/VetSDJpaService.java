package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.Vet;
import com.maartenmusic.petclinic.repositories.VetRepository;
import com.maartenmusic.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Profile("springdatajpa")
public class VetSDJpaService extends AbstractSDJpaService<Vet, VetRepository> implements VetService {

    public VetSDJpaService(VetRepository repository) {
        super(repository);
    }
}
