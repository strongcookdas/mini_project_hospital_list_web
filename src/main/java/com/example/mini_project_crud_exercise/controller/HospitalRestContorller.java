package com.example.mini_project_crud_exercise.controller;

import com.example.mini_project_crud_exercise.domian.entity.Hospital;
import com.example.mini_project_crud_exercise.domian.response.HospitalResponse;
import com.example.mini_project_crud_exercise.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalRestContorller {
    private final HospitalRepository hospitalRepository;

    public HospitalRestContorller(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        return ResponseEntity.ok().body(Hospital.of(optionalHospital.get()));
    }
}
