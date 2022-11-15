package com.example.mini_project_crud_exercise.service;

import com.example.mini_project_crud_exercise.domian.dto.HospitalResponse;
import com.example.mini_project_crud_exercise.domian.entity.Hospital;
import com.example.mini_project_crud_exercise.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Entity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> hospitalOption = hospitalRepository.findById(id);
        if (hospitalOption.isEmpty()) {
            log.info("id에 해당하는 데이터가 없습니다.");
            return null;
        } else {
            Hospital hospital = hospitalOption.get();
            HospitalResponse hospitalResponse = Hospital.of(hospital);
            switch (hospital.getBusinessStatusCode()) {
                case 13:
                    hospitalResponse.setBusinessStatusNumber("영업중");
                    break;
                case 3:
                    hospitalResponse.setBusinessStatusNumber("폐업");
                    break;
                default:
                    hospitalResponse.setBusinessStatusNumber(String.valueOf(hospital.getBusinessStatusCode()));
            }
            return hospitalResponse;
        }
    }
}
