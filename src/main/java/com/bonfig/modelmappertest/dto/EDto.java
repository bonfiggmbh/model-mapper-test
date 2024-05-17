package com.bonfig.modelmappertest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EDto {
  private BaseDto element;
  private List<BaseDto> elements;
}
