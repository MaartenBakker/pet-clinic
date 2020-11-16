package com.maartenmusic.petclinic.controllers;

import com.maartenmusic.petclinic.model.Owner;
import com.maartenmusic.petclinic.model.Pet;
import com.maartenmusic.petclinic.model.PetType;

import com.maartenmusic.petclinic.services.OwnerService;
import com.maartenmusic.petclinic.services.PetService;
import com.maartenmusic.petclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {

    public static final String VIEWS_PET_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return this.ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = Pet.builder().build();
        owner.getPets().add(pet);
        model.addAttribute("pet", pet);
        return VIEWS_PET_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if(result.hasErrors()) {
            model.addAttribute("pet", pet );
            return VIEWS_PET_CREATE_OR_UPDATE_FORM;
        } else {
            this.petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }
}
