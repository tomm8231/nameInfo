package com.example.apihandin2.api;

import com.example.apihandin2.dto.NameInfoResponse;
import com.example.apihandin2.service.NameInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/name-info")
public class NameController {

  NameInfoService nameService;

  public NameController(NameInfoService nameService){
    this.nameService = nameService;
  }

  @GetMapping()
  public NameInfoResponse getGenderForName(@RequestParam String name) {
    NameInfoResponse res = nameService.fetchNameDetails(name);
    return res;
  }
}
