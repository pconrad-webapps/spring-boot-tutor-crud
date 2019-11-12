package com.baeldung.crud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.baeldung.crud.entities.Tutor;
import com.baeldung.crud.repositories.TutorRepository;
import com.baeldung.crud.repositories.CourseOfferingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {
    
    private Logger logger = LoggerFactory.getLogger(TutorController.class);

    @Autowired
    public HomeController() {
    }
     
    @GetMapping("/")
    public String home(Model model) {
        logger.info("Entering TutorController.home.  model="+model.toString());
        return "index";
    }

   
   

}
