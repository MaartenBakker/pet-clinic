package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.PetType;
import com.maartenmusic.petclinic.repositories.PetTypeRepository;
import com.maartenmusic.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PetTypeSDJpaService extends AbstractSDJpaService<PetType, PetTypeRepository>
        implements PetTypeService {

    public PetTypeSDJpaService(PetTypeRepository repository) {
        super(repository);
    }
}
