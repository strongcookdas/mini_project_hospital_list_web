package com.example.mini_project_crud_exercise.repository;

import com.example.mini_project_crud_exercise.domian.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("hospitalRepository 테스트")
    void hospitalRepositoryTest() {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(1);
        System.out.println(optionalHospital.get().toString());
    }

    @Test
    @DisplayName("findByFullAddressStartingWithAndHospitalNameLike 테스트")
    void findByFullAddressStartingWithAndHospitalNameLikeTest() {
        List<Hospital> list = hospitalRepository.findByFullAddressStartingWithAndHospitalNameLike("경기도 수원시","%피부과%");
        for (Hospital hospital :
                list) {
            System.out.println(hospital.toString());
        }
    }

    @Test
    @DisplayName("findByBusinessTypeNameIn 테스트")
    void findByBusinessTypeNameInTest() {
        List<String> type  = new ArrayList<>();
        type.add("보건소");
        type.add("보건지소");
        type.add("보건진료소");
        List<Hospital> list = hospitalRepository.findByBusinessTypeNameIn(type);
        for (Hospital hospital :
                list) {
            System.out.println(hospital.toString());
        }
    }
    @Test
    void containing() {
        List<Hospital> list = hospitalRepository.findByRoadNameAddressContaining("송파구");
        for (Hospital hospital :
                list) {
            System.out.println(hospital.toString());
        }
    }
    @Test
    void startsWith() {
        List<Hospital> list = hospitalRepository.findByRoadNameAddressStartsWith("경희");// 가톨릭 서울 연세 경희1
        for (Hospital hospital :
                list) {
            System.out.println(hospital.toString());
        }
    }
    @Test
    void endsWith() {
        List<Hospital> list = hospitalRepository.findByRoadNameAddressEndingWith("병원");// 의원, 병원, 이비인후과, 치과
        for (Hospital hospital :
                list) {
            System.out.println(hospital.toString());
        }
    }
    @Test
    void findByPatientRoomCountAndPatientRoomCount() {
        List<Hospital> list = hospitalRepository.findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan(10, 20);// 의원, 병원, 이비인후과, 치과
        for (Hospital hospital :
                list) {
            System.out.println(hospital.toString());
        }
    }
}