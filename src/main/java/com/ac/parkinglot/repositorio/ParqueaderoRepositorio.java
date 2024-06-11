package com.ac.parkinglot.repositorio;

import com.ac.parkinglot.dominio.Parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueaderoRepositorio extends JpaRepository<Parqueadero, Long> {
}
