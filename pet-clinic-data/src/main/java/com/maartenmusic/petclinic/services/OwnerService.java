package com.maartenmusic.petclinic.services;

import com.maartenmusic.petclinic.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    @Override
    Set<Owner> findAll();

    List<Owner> findAllByLastNameLike(String lastName);

}
