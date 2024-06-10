package com.ac.parkinglot.mapper;

import com.ac.parkinglot.dominio.Parqueadero;
import com.ac.parkinglot.dto.ParqueaderoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ParqueaderoMapper {

    @Autowired
    ModelMapper modelMapper;

    public Parqueadero dtoAEntidad(ParqueaderoDto parqueaderoDto){
        Parqueadero parqueadero = modelMapper.map(parqueaderoDto, Parqueadero.class);
        return parqueadero;
    }
}
