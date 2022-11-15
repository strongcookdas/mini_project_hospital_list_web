package com.example.mini_project_crud_exercise.domian.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class HospitalResponse {
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
    private String businessStatusNumber;
    private Float totalAreaSize;

    public HospitalResponse(Integer id, String openServiceName, String phone, String fullAddress, String roadNameAddress, String hospitalName, String businessTypeName, Integer healthcareProviderCount, Integer patientRoomCount, Integer totalNumberOfBeds, Float totalAreaSize) {
        this.id = id;
        this.openServiceName = openServiceName;
        this.phone = phone;
        this.fullAddress = fullAddress;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
        this.healthcareProviderCount = healthcareProviderCount;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.totalAreaSize = totalAreaSize;
    }

    public void setBusinessStatusNumber(String businessStatusNumber) {
        this.businessStatusNumber = businessStatusNumber;
    }
}
