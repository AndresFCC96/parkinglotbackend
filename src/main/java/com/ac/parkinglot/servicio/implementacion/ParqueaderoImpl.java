package com.ac.parkinglot.servicio.implementacion;

import com.ac.parkinglot.dominio.Parqueadero;
import com.ac.parkinglot.repositorio.ParqueaderoRepositorio;
import com.ac.parkinglot.servicio.ParqueaderoService;
import com.ac.parkinglot.servicio.VehiculoServicio;
import com.ac.parkinglot.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParqueaderoImpl implements ParqueaderoService {

    @Autowired
    ParqueaderoRepositorio parqueaderoRepositorio;

    Parqueadero parqueadero = Parqueadero.builder().plazasCarros(5L).plazasMotos(6L).totalDiaGanancias(0L).build();

    @Override
    public Parqueadero calcularPlazasVehiculo(String tipoVehiculo, String estado) throws Exception {
        String tipo = Utils.primerLetraMayuscula(tipoVehiculo).equals("Carro") ? Utils.CARRO : Utils.MOTO;
        validarPlazas(tipoVehiculo);
        if(estado.equals(Utils.ENTRADA)){
            entradaVehiculo(tipo);
        }else {
            salidaVehiculo(tipo);
        }
        return parqueaderoRepositorio.save(parqueadero);
    }

    public void validarPlazas(String tipo) throws Exception {
        if(tipo.equals(Utils.CARRO) && parqueadero.getPlazasCarros() <= 0){
            throw new Exception("Ya no hay espacio para carros");
        }
        if(tipo.equals(Utils.MOTO) && parqueadero.getPlazasMotos() <= 0){
            throw new Exception("Ya no hay espacio para motos");
        }
    }

    public void entradaVehiculo(String tipo) throws Exception{
        if (tipo.equals(Utils.ENTRADA)){
            if(tipo.equals(Utils.CARRO) ){
                if( parqueadero.getPlazasCarros() > 0){
                    parqueadero.setPlazasCarros(parqueadero.getPlazasCarros() - 1);
                }else{
                    throw new Exception("No hay donde estacionar mas carros");
                }
            }else{
                if( parqueadero.getPlazasMotos() > 0){
                    parqueadero.setPlazasMotos(parqueadero.getPlazasMotos() - 1);
                }else{
                    throw new Exception("No hay donde estacionar mas motos");
                }
            }
        }
    }

    public void salidaVehiculo(String tipo) throws Exception{
        if(tipo.equals(Utils.CARRO)){
            if(parqueadero.getPlazasCarros() < 5){
                parqueadero.setPlazasCarros(parqueadero.getPlazasCarros() + 1);
            }else{
                throw new Exception("No se puede sacar un carro que no existe");
            }
        }else{
            if(parqueadero.getPlazasMotos() < 5){
                parqueadero.setPlazasMotos(parqueadero.getPlazasMotos() + 1);
            }else{
                throw new Exception("No se puede sacar una moto que no existe");
            }
        }
    }
}
