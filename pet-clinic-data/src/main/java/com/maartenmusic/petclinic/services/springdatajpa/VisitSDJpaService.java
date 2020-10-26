package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.Visit;
import com.maartenmusic.petclinic.repositories.VisitRepository;
import com.maartenmusic.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService extends AbstractSDJpaService<Visit, VisitRepository> implements VisitService {

    public VisitSDJpaService(VisitRepository repository) {
        super(repository);
    }
}
