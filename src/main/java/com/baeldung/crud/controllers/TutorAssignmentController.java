package com.baeldung.crud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baeldung.crud.entities.TutorAssignment;
import com.baeldung.crud.entities.Tutor;
import com.baeldung.crud.entities.CourseOffering;
import com.baeldung.crud.repositories.TutorAssignmentRepository;
import com.baeldung.crud.repositories.TutorRepository;
import com.baeldung.crud.repositories.CourseOfferingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TutorAssignmentController {

    private Logger logger = LoggerFactory.getLogger(TutorAssignmentController.class);

    private final TutorAssignmentRepository tutorAssignmentRepository;
    private final TutorRepository tutorRepository;
    private final CourseOfferingRepository courseOfferingRepository;

    @Autowired
    public TutorAssignmentController(TutorAssignmentRepository tutorAssignmentRepository,
            TutorRepository tutorRepository, CourseOfferingRepository courseOfferingRepository) {
        this.tutorAssignmentRepository = tutorAssignmentRepository;
        this.tutorRepository = tutorRepository;
        this.courseOfferingRepository = courseOfferingRepository;
    }

    @PostMapping("/tutorAssignments/add")
    public String add(@RequestParam(name = "cid") long cid, @RequestParam(name = "tid") long tid, Model model) {
        Tutor tutor = tutorRepository.findById(tid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tutor Id:" + tid));
        CourseOffering courseOffering = courseOfferingRepository.findById(cid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course offering Id:" + cid));
        TutorAssignment tutorAssignment = new TutorAssignment(tutor, courseOffering);
        tutorAssignmentRepository.save(tutorAssignment);
        model.addAttribute("tutorAssignments",tutorAssignmentRepository.findAll());
        return "index";
    }

    @GetMapping("/tutorAssignments/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        TutorAssignment a = tutorAssignmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tutor assignment Id:" + id));
        tutorAssignmentRepository.delete(a);
        model.addAttribute("tutorAssignments",tutorAssignmentRepository.findAll());
        return "index";
    }
}
