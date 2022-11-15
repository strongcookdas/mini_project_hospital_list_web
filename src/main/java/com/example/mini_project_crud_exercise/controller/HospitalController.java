package com.example.mini_project_crud_exercise.controller;

import com.example.mini_project_crud_exercise.domian.entity.Hospital;
import com.example.mini_project_crud_exercise.repository.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hospitals")
public class HospitalController {
    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    private final HospitalRepository hospitalRepository;

    @GetMapping("")
    public String hospitalList(Pageable pageable, Model model){
        Page<Hospital> list = hospitalRepository.findAll(pageable);
        model.addAttribute("hospitals",list);
        model.addAttribute("previous",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "hospitals/list";
    }

    @GetMapping("/{id}")
    public String hospitalPage(@PathVariable int id, Model model){
        Optional<Hospital>optionalHospital = hospitalRepository.findById(id);
        if(optionalHospital.isEmpty())
            return "articles/error";
        else{
            model.addAttribute("hospital",optionalHospital.get());
            return "hospitals/show";
        }
    }
}
