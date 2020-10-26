package com.maartenmusic.petclinic.services.map;

import com.maartenmusic.petclinic.model.Visit;
import com.maartenmusic.petclinic.services.PetService;
import com.maartenmusic.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private final PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if (object == null || object.getPet() == null || object.getPet().getOwner() == null
            || object.getPet().getId() == null || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }

            return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
