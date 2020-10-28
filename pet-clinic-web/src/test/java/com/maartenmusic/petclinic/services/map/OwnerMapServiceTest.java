package com.maartenmusic.petclinic.services.map;

import com.maartenmusic.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Owner owner = new Owner();
    final String lastName = "Bakker";

    @BeforeEach
    void Setup(){
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        owner.setLastName(lastName);
        ownerMapService.save(owner);
    }

    @Test
    void findByLastName() {
        Owner owner2 = ownerMapService.findByLastName(lastName);

        assertNotNull(owner2);

        assertEquals(owner, owner2);
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner2 = ownerMapService.findByLastName("foo");

        assertNull(owner2);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1L);

        assertEquals(1L, owner.getId());
    }

    @Test
    void saveAutoIncrId() {
        Owner owner2 = ownerMapService.save(new Owner());

        assertEquals(2L, owner2.getId());
    }

    @Test
    void saveCustomId() {
        Owner owner2 = Owner.builder().id(10L).build();
        Owner owner3 = ownerMapService.save(owner2);

        assertEquals(10L, owner3.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(owner);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);

        assertEquals(0, ownerMapService.findAll().size());
    }
}