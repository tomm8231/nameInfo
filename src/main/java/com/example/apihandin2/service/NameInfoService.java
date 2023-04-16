package com.example.apihandin2.service;

import com.example.apihandin2.dto.AgeResponse;
import com.example.apihandin2.dto.NameInfoResponse;
import com.example.apihandin2.dto.GenderResponse;
import com.example.apihandin2.dto.NationalityResponse;
import com.example.apihandin2.entity.NameInfo;
import com.example.apihandin2.repository.NameInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class NameInfoService {
  NameInfoRepository nameInfoRepository;

  public NameInfoService(NameInfoRepository nameInfoRepository) {
    this.nameInfoRepository = nameInfoRepository;
  }


  Mono<GenderResponse> getGender(String name) {
    WebClient client = WebClient.create();
    Mono<GenderResponse> gender = client.get()
        .uri("https://api.genderize.io?name="+name)
        .retrieve()
        .bodyToMono(GenderResponse.class);
    return gender;
  }

  Mono<AgeResponse> getAge(String name) {
    WebClient client = WebClient.create();
    Mono<AgeResponse> age = client.get()
        .uri("https://api.agify.io?name="+name)
        .retrieve()
        .bodyToMono(AgeResponse.class);
    return age;
  }

  Mono<NationalityResponse> getNationality(String name) {
    WebClient client = WebClient.create();
    Mono<NationalityResponse> nationality = client.get()
        .uri("https://api.nationalize.io?name="+name)
        .retrieve()
        .bodyToMono(NationalityResponse.class);
    return nationality;
  }

  public NameInfoResponse fetchNameDetails(String name) {

    Optional<NameInfo> foundName = nameInfoRepository.findById(name);
    if (!foundName.isPresent()) {
      System.out.println("Not in db: " + name);

      Mono<GenderResponse> gender = getGender(name);
      Mono<AgeResponse> age = getAge(name);
      Mono<NationalityResponse> nationality = getNationality(name);

      Mono<NameInfo> mono = Mono.zip(age, gender, nationality)
          .map(tuple -> new NameInfo(tuple.getT1(), tuple.getT2(),tuple.getT3()));

      NameInfo nameInfo = mono.block();

      nameInfoRepository.save((nameInfo));

      NameInfoResponse nameInfoResponse = new NameInfoResponse(nameInfo);

      return nameInfoResponse;

    } else {
      System.out.println("Already in db: " + name);
      NameInfoResponse nameInfoResponse = new NameInfoResponse(foundName.get());
      return nameInfoResponse;

    }

  }

}
