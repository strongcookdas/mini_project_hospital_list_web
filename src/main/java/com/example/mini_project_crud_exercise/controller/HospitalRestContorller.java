package com.example.mini_project_crud_exercise.controller;

import com.example.mini_project_crud_exercise.domian.entity.Hospital;
import com.example.mini_project_crud_exercise.domian.dto.HospitalResponse;
import com.example.mini_project_crud_exercise.repository.HospitalRepository;
import com.example.mini_project_crud_exercise.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalRestContorller {
    private final HospitalService hospitalService;

    public HospitalRestContorller(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }
}
