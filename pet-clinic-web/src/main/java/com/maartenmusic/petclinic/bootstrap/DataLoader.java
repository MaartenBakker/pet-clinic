package com.maartenmusic.petclinic.bootstrap;

import com.maartenmusic.petclinic.model.Owner;
import com.maartenmusic.petclinic.model.Pet;
import com.maartenmusic.petclinic.model.PetType;
import com.maartenmusic.petclinic.model.Vet;
import com.maartenmusic.petclinic.services.OwnerService;
import com.maartenmusic.petclinic.services.PetTypeService;
import com.maartenmusic.petclinic.services.VetService;
import com.maartenmusic.petclinic.services.map.OwnerServiceMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        dog.setName("Dog");

        PetType savedDogPetType =  petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Maarten");
        owner1.setLastName("Bakker");
        owner1.setAddress("Teststraat 1");
        owner1.setCity("Oudewater");
        owner1.setTelephone("061234567");

        Pet maartensPet = new Pet();
        maartensPet.setPetType(savedCatPetType);
        maartensPet.setOwner(owner1);
        maartensPet.setBirthDate(LocalDate.now());
        maartensPet.setName("Darwin");
        owner1.getPets().add(maartensPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anna");
        owner2.setLastName("Zeijlemaker");
        owner2.setAddress("Teststraat 2");
        owner2.setCity("Tokyo");
        owner2.setTelephone("067654321");

        Pet annasPet = new Pet();
        annasPet.setPetType(savedDogPetType);
        annasPet.setOwner(owner2);
        annasPet.setBirthDate(LocalDate.now());
        annasPet.setName("Schnitzel");
        owner2.getPets().add(annasPet);


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
