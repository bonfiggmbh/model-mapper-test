package com.bonfig.modelmappertest;

import com.bonfig.modelmappertest.dto.ADto;
import com.bonfig.modelmappertest.dto.BaseDto;
import com.bonfig.modelmappertest.dto.EDto;
import com.bonfig.modelmappertest.model.A;
import com.bonfig.modelmappertest.model.Base;
import com.bonfig.modelmappertest.model.E;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

/**
 * The purpose of this class is to demonstrate the correct configuration of the ModelMapper to support field types with
 * class inheritance.
 */
public class ModelToDtoMapper {
  private final ModelMapper mapper;

  public ModelToDtoMapper() {
    mapper = new ModelMapper();

    // The explicit mapping is required, otherwise the mapper will try to instantiate the abstract
    // base class BaseDto. For the "List<Base> elements" field this is not necessary.
    //
    // Note: Sine ModelMapper version 3.1.1 to map a complex field, you need to add mappings to an
    // empty TypeMap and add the implicit mappings by calling implicitMappings().
    mapper.emptyTypeMap(E.class, EDto.class)
        .addMappings(m -> m
            .map(E::getElement, EDto::setElement))
        .implicitMappings();

    // The optional base class mapping. Here we use an uppercase converter to check if the base
    // mapping is executed.
    mapper.typeMap(Base.class, BaseDto.class)
        .addMappings(m -> m
            .using((Converter<String, String>) c -> c.getSource().toUpperCase())
            .map(Base::getBaseValue, BaseDto::setBaseValue));

    // Map the derived source class(es) to the base destination class.
    mapper.typeMap(A.class, BaseDto.class)
        // We need to use getProvider with a call to mapper here. If you use setConverter with the
        // same mapping, the mapper will skip the base class mapping.
        .setProvider(c -> mapper.map(c.getSource(), ADto.class))
        // If an explicit base class mapping exists, we need to include it here.
        .includeBase(Base.class, BaseDto.class);

    mapper.validate();
  }

  public EDto map(final E e) {
    return mapper.map(e, EDto.class);
  }
}
