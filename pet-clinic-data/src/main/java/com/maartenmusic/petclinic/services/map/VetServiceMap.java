package com.maartenmusic.petclinic.services.map;

import com.maartenmusic.petclinic.model.Vet;
import com.maartenmusic.petclinic.services.SpecialityService;
import com.maartenmusic.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            if (!object.getSpecialities().isEmpty()) {
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        specialityService.save(speciality);
                    }
                });
            }

            return super.save(object);
        }

        return null;
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
