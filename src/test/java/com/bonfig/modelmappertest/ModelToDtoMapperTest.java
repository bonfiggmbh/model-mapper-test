package com.bonfig.modelmappertest;

import com.bonfig.modelmappertest.dto.ADto;
import com.bonfig.modelmappertest.dto.BaseDto;
import com.bonfig.modelmappertest.dto.EDto;
import com.bonfig.modelmappertest.model.A;
import com.bonfig.modelmappertest.model.Base;
import com.bonfig.modelmappertest.model.E;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ModelToDtoMapperTest {
  private final ModelToDtoMapper mapper = new ModelToDtoMapper();

  private static void assertEqualsElement(final Base element, final BaseDto elementDto) {
    assertEquals(element.getBaseValue().toUpperCase(), elementDto.getBaseValue());
    assertInstanceOf(A.class, element);
    assertInstanceOf(ADto.class, elementDto);
    assertEquals(((A) element).getValue(), ((ADto) elementDto).getValue());
  }

  @Test
  void test() {
    final E e = new E(new A("A.baseValue in element", "A.value in element"),
        List.of(new A("A.baseValue in elements", "A.value in elements")));

    final EDto eDto = mapper.map(e);

    assertNotNull(eDto);
    assertEqualsElement(e.getElement(), eDto.getElement());
    assertNotNull(e.getElements());
    assertNotNull(eDto.getElements());
    assertEquals(1, e.getElements().size());
    assertEquals(1, eDto.getElements().size());
    assertEqualsElement(e.getElements().getFirst(), eDto.getElements().getFirst());
  }

}
