package com.ac.parkinglot.mapper;

import com.ac.parkinglot.dominio.Vehiculo;
import com.ac.parkinglot.dto.VehiculoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehiculoMapper {

    @Autowired
    ModelMapper modelMapper;

    public Vehiculo dtoAEntidad(VehiculoDto vehiculoDto){
        Vehiculo vehiculo = modelMapper.map(vehiculoDto, Vehiculo.class);
        return vehiculo;
    }
}
