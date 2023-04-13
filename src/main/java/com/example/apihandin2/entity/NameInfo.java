package com.example.apihandin2.entity;

import com.example.apihandin2.dto.AgeResponse;
import com.example.apihandin2.dto.GenderResponse;
import com.example.apihandin2.dto.NationalityCountryResponse;
import com.example.apihandin2.dto.NationalityResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class NameInfo {

  @Id
  String name;
  int age;
  String gender;
  double genderProbability;
  int ageCount;
  String country;
  double countryProbability;



  public NameInfo(AgeResponse ageResponse, GenderResponse genderResponse, NationalityResponse nationalityResponse) {


    name = genderResponse.getName();
    gender = genderResponse.getGender();
    genderProbability = genderResponse.getProbability();
    age = ageResponse.getAge();
    ageCount = ageResponse.getCount();

    //Efter Tomas' kode
    country = nationalityResponse.getCountry().get(0).getCountry_id();
    countryProbability = nationalityResponse.getCountry().get(0).getProbability();
  }

}
