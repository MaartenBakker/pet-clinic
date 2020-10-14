package com.maartenmusic.petclinic.services.map;

import com.maartenmusic.petclinic.model.Owner;
import com.maartenmusic.petclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> ownerSet = super.findAll();
        for (Owner owner : ownerSet) {
            if(owner.getLastName().equals(lastName)) {
                return owner;
            }
        }
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Long id, Owner object) {
        return super.save(id, object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
