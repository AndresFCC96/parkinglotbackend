package com.ac.parkinglot.servicio.implementacion;

import com.ac.parkinglot.dominio.Vehiculo;
import com.ac.parkinglot.dto.VehiculoDto;
import com.ac.parkinglot.mapper.VehiculoMapper;
import com.ac.parkinglot.repositorio.VehiculoRepositorio;
import com.ac.parkinglot.servicio.VehiculoServicio;
import com.ac.parkinglot.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoImpl implements VehiculoServicio {

    @Autowired
    VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    VehiculoMapper vehiculoMapper;

    @Override
    public List<Vehiculo> buscarTodos() throws Exception {
        List<Vehiculo> listaVehiculos = vehiculoRepositorio.findAll();
        if(listaVehiculos.isEmpty()){
            throw new Exception("No hay vehiculos en el garage");
        }else{
            return listaVehiculos;
        }
    }

    @Override
    public Vehiculo buscarPorId(Long vehiculoId) throws Exception {
        Optional<Vehiculo> buscarVehiculo = vehiculoRepositorio.findById(vehiculoId);
        if (buscarVehiculo.isEmpty()){
            throw new Exception("No hay vehiculo con ese ID");
        }else{
            return buscarVehiculo.get();
        }
    }

    @Override
    public Vehiculo buscarPorPlaza(Long plaza) throws Exception {
        Optional<Vehiculo> buscarVehiculo = vehiculoRepositorio.findById(plaza);
        if (buscarVehiculo.isEmpty()){
            throw new Exception("No hay vehiculo estacionado en la plaza " + String.valueOf(plaza));
        }else{
            return buscarVehiculo.get();
        }
    }

    //Falta hacer el servicio para ver cuantas plazas hay disponibles y si se puede parquear
    @Override
    public Vehiculo ingresarVehiculo(VehiculoDto vehiculoDTO) throws Exception {
        if(vehiculoDTO == null){
            throw new Exception("Debe introducir los datos del vehiculo");
        }

        if(validarPorPlaza(vehiculoDTO.getPlaza())){
            throw new Exception("Ya existe un vehiculo en esa plaza");
        }

        if(vehiculoDTO.getPlaza() < 0){
            throw new Exception("Debe introducir un numero de plaza valido");
        }

        Vehiculo vehiculo = vehiculoMapper.dtoAEntidad(vehiculoDTO);
        return vehiculoRepositorio.save(vehiculo);

    }

    @Override
    public Vehiculo modificarVehiculo(VehiculoDto vehiculoDTO) throws Exception {
        if(vehiculoDTO == null){
            throw new Exception("Debe introducir los datos del vehiculo");
        }

        if(vehiculoDTO.getPlaza() < 0){
            throw new Exception("El vehiculo que quiere eliminar no esta en una plaza valida");
        }

        if(!validarPorPlaca(vehiculoDTO.getPlaca())){
            throw new Exception("No hay ningun vehiculo con la placa " + vehiculoDTO.getPlaca() + " en el parqueadero");
        } else{
            Vehiculo vehiculo = vehiculoMapper.dtoAEntidad(vehiculoDTO);
            return vehiculoRepositorio.save(vehiculo);
        }
    }

    @Override
    public void eliminarVehiculo(Long vehiculoId) throws Exception {
        if(vehiculoId == null || vehiculoId < 0){
            throw new Exception("Debe introducir el id del vehiculo");
        }

        Vehiculo vehiculo = buscarPorId(vehiculoId);

        vehiculoRepositorio.delete(vehiculo);
    }

    @Override
    public Vehiculo generarCobroSalidaVehiculo(VehiculoDto vehiculoDTO) throws Exception {

        if(vehiculoDTO == null){
            throw new Exception("Debe introducir los datos del vehiculo");
        }

        if(!validarPorPlaca(vehiculoDTO.getPlaca())){
            throw new Exception("No hay ningun vehiculo con la placa " + vehiculoDTO.getPlaca() + " en el parqueadero");
        }

        if(vehiculoDTO.getFechaSalida() == null){
            throw new Exception("Para poder salir el vehiculo debe de tener una fecha salida");
        }

        Vehiculo vehiculo = vehiculoMapper.dtoAEntidad(vehiculoDTO);
        vehiculo.setTotalHoras(Utils.totalHoras(vehiculoDTO.getFechaEntrada(), vehiculoDTO.getFechaSalida()));
        vehiculo.setCobro(Utils.cobro(vehiculo.getTipoVehiculo(), vehiculo.getModelo(), vehiculo.getTotalHoras()));
        vehiculo.setPlaza(0);
        return vehiculo;
    }

    public boolean validarPorPlaca(String placa){
        Optional<Vehiculo> vehiculoPlaca = vehiculoRepositorio.findByPlaca(placa);
        return vehiculoPlaca.isPresent();
    }

    public boolean validarPorPlaza(int plaza){
        Optional<Vehiculo> vehiculoPlaza = vehiculoRepositorio.findByPlaza(plaza);
        return vehiculoPlaza.isPresent();
    }

}
