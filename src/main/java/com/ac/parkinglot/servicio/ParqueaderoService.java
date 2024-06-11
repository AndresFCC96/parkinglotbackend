package com.ac.parkinglot.servicio;

import com.ac.parkinglot.dominio.Parqueadero;
import org.springframework.stereotype.Service;

@Service
public interface ParqueaderoService {


    public Parqueadero calcularPlazasVehiculo(String tipo, String estado) throws Exception;
}
