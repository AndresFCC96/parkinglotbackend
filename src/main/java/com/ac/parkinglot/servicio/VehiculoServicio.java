package com.ac.parkinglot.servicio;

import com.ac.parkinglot.dominio.Vehiculo;
import com.ac.parkinglot.dto.VehiculoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehiculoServicio {

    public List<Vehiculo> buscarTodos() throws Exception;
    public Vehiculo buscarPorId(Long vehiculoId) throws Exception;
    public Vehiculo buscarPorPlaza(Long plaza) throws Exception;
    public Vehiculo ingresarVehiculo(VehiculoDto vehiculoDTO) throws Exception;
    public Vehiculo modificarVehiculo(VehiculoDto vehiculoDTO) throws Exception;
    public Vehiculo generarCobroSalidaVehiculo(VehiculoDto vehiculoDTO) throws Exception;
    public void eliminarVehiculo(Long vehiculoId) throws Exception;
}
