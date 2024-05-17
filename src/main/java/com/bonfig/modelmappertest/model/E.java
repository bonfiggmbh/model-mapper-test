package com.bonfig.modelmappertest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class E {
  private Base element;
  private List<Base> elements;
}
