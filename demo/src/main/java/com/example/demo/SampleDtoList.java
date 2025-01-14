package com.example.demo;

import com.example.demo.di.SampleDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SampleDtoList {
  List<SampleDTO> list = new ArrayList<>();
  
  
}
