package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.Owner;
import com.maartenmusic.petclinic.repositories.OwnerRepository;
import com.maartenmusic.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OwnerSDJpaService extends AbstractSDJpaService<Owner, OwnerRepository> implements OwnerService {

    public OwnerSDJpaService(OwnerRepository repository) {
        super(repository);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
