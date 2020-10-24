package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.Speciality;
import com.maartenmusic.petclinic.repositories.SpecialityRepository;
import com.maartenmusic.petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialitySDJpaService extends AbstractSDJpaService<Speciality, SpecialityRepository>
        implements SpecialityService {

    public SpecialitySDJpaService(SpecialityRepository repository) {
        super(repository);
    }
}
