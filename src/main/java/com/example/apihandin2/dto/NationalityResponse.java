package com.example.apihandin2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public
class NationalityResponse {

  public ArrayList<NationalityCountryResponse> country;
  public String name;

  }

