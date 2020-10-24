package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.Visit;
import com.maartenmusic.petclinic.repositories.VisitRepository;
import com.maartenmusic.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VisitSDJpaService extends AbstractSDJpaService<Visit, VisitRepository> implements VisitService {

    public VisitSDJpaService(VisitRepository repository) {
        super(repository);
    }
}
