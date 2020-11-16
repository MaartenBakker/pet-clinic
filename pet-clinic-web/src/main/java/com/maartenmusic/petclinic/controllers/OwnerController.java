package com.maartenmusic.petclinic.controllers;

import com.maartenmusic.petclinic.model.Owner;
import com.maartenmusic.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    public static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

//    @GetMapping({"", "/", "/index", "/index.html"})
//    public String listOwners(Model model) {
//        model.addAttribute("owners", ownerService.findAll());
//
//        return "owners/index";
//    }

    @GetMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", new Owner());

        return "owners/findowners";

    }

    @GetMapping("/{ownerId}")
    public ModelAndView displayOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerdetails");

        mav.addObject(ownerService.findById(ownerId));

        return mav;
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        } else {
            String lastName = owner.getLastName();
            lastName = lastName.trim();


            if (lastName.length() != 0) {
                lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
            }
            owner.setLastName(lastName);
        }

        //find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        if (results.size() == 0) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findowners";
        } else if (results.size() == 1) {
            //1 owner found
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            //multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownerslist";
        }
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", new Owner());

        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@ModelAttribute Owner owner, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }


    @GetMapping("/{ownerId}/edit")
    public String initUpdateForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerId));
        System.out.println("Found ownerId: " + ownerService.findById(ownerId).getId());

        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;

    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateForm(Owner owner, BindingResult result, @PathVariable Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            System.out.println("Saving owner with id:" + owner.getId());
//            owner.setId(ownerId); Only needed when owner.id is not persisted in Thymeleaf form
            Owner savedOwner = ownerService.save(owner);
            System.out.println("SavedownerId: " + savedOwner.getId());
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

}