package com.example.apihandin2.dto;

import com.example.apihandin2.entity.NameInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NameInfoResponse {

String name;
int age;
String gender;
double genderProbability;
int ageCount;
String country;
double countryProbability;


  public NameInfoResponse(NameInfo nameInfo) {
    name = nameInfo.getName();
    gender = nameInfo.getGender();
    genderProbability = nameInfo.getGenderProbability();
    age = nameInfo.getAge();
    ageCount = nameInfo.getAgeCount();

    //Efter Tomas' kode
    country = nameInfo.getCountry();
    countryProbability = nameInfo.getCountryProbability();
  }
}
