package com.ac.parkinglot.repositorio;

import com.ac.parkinglot.dominio.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {

    Optional<Vehiculo> findByPlaca(String placa);
    Optional<Vehiculo> findByPlaza(int plaza);
}
