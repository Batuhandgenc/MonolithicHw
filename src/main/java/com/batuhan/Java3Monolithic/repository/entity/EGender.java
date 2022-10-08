package com.batuhan.Java3Monolithic.repository.entity;


import lombok.Getter;

@Getter
public enum EGender {
    MALE("Male") , FEMALE("Female"), NONE("None");
    String gender;
    EGender(String gender) {
        this.gender=gender;
    }
}
