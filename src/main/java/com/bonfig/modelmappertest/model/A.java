package com.bonfig.modelmappertest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class A extends Base {
  private String value;

  public A(final String baseValue, final String value) {
    super(baseValue);
    this.value = value;
  }
}
