package com.maartenmusic.petclinic.bootstrap;

import com.maartenmusic.petclinic.model.*;
import com.maartenmusic.petclinic.services.*;
import com.maartenmusic.petclinic.services.map.OwnerServiceMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetService petService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        // only load dummy data if no populated database is connected
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
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
        Pet savedMaartensPet = petService.save(maartensPet);

        owner1.getPets().add(savedMaartensPet);

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
        Pet savedAnnasPet = petService.save(annasPet);


        owner2.getPets().add(savedAnnasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Vet vet1 = new Vet();
        vet1.setFirstName("Pipo");
        vet1.setLastName("DeClown");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mama");
        vet2.setLastName("Lou");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);


        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
