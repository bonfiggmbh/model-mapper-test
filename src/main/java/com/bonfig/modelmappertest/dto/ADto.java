package com.bonfig.modelmappertest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ADto extends BaseDto {
  private String value;

  public ADto(final String baseValue, final String value) {
    super(baseValue);
    this.value = value;
  }
}
