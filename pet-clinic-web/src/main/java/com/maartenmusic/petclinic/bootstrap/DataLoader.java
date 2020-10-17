package com.maartenmusic.petclinic.bootstrap;

import com.maartenmusic.petclinic.model.Owner;
import com.maartenmusic.petclinic.model.Vet;
import com.maartenmusic.petclinic.services.OwnerService;
import com.maartenmusic.petclinic.services.VetService;
import com.maartenmusic.petclinic.services.map.OwnerServiceMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(@Qualifier("ownerServiceMap") OwnerService ownerService,
                      @Qualifier("vetServiceMap") VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Maarten");
        owner1.setLastName("Bakker");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Anna");
        owner1.setLastName("Zeijlemaker");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Pipo");
        vet1.setLastName("DeClown");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mama");
        vet2.setLastName("Lou");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
