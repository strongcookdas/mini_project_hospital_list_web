package com.example.mini_project_crud_exercise.domian.entity;

import com.example.mini_project_crud_exercise.domian.response.HospitalResponse;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nation_wide_hospitals")
@Getter
@ToString
public class Hospital {

    @Id
    private Integer id;

    private String openServiceName;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private Integer healthcareProviderCount;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;

    public static HospitalResponse of(Hospital hospital){
        return new HospitalResponse(hospital.getId(), hospital.getOpenServiceName(), hospital.getPhone(), hospital.getFullAddress(), hospital.getRoadNameAddress(), hospital.getHospitalName(),
        hospital.getBusinessTypeName(),hospital.getHealthcareProviderCount(),hospital.getPatientRoomCount(),hospital.getTotalNumberOfBeds(),hospital.getTotalAreaSize());
    }
}
