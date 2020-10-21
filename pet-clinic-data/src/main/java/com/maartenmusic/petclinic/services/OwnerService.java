package com.maartenmusic.petclinic.services;

import com.maartenmusic.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
