package com.maartenmusic.petclinic.bootstrap;

import com.maartenmusic.petclinic.model.Owner;
import com.maartenmusic.petclinic.model.PetType;
import com.maartenmusic.petclinic.model.Vet;
import com.maartenmusic.petclinic.services.OwnerService;
import com.maartenmusic.petclinic.services.PetTypeService;
import com.maartenmusic.petclinic.services.VetService;
import com.maartenmusic.petclinic.services.map.OwnerServiceMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Schnitzel");

        PetType savedDogPetType =  petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Darwin");

        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Maarten");
        owner1.setLastName("Bakker");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anna");
        owner2.setLastName("Zeijlemaker");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Pipo");
        vet1.setLastName("DeClown");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mama");
        vet2.setLastName("Lou");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
