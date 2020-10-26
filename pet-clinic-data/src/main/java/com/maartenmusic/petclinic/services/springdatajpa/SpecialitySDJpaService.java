package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.Speciality;
import com.maartenmusic.petclinic.repositories.SpecialityRepository;
import com.maartenmusic.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService extends AbstractSDJpaService<Speciality, SpecialityRepository>
        implements SpecialityService {

    public SpecialitySDJpaService(SpecialityRepository repository) {
        super(repository);
    }
}
