package com.ac.parkinglot.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(schema = "vehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "placa", nullable = false, length = 6)
    private String placa;

    @Column(name = "tipo_vehiculo", nullable = false, length = 1)
    private String tipoVehiculo;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "descuento")
    private boolean descuento;

    @Column(name = "fecha_entrada", nullable = false)
    private LocalDateTime fechaEntrada;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name = "plaza", nullable = false)
    private int plaza;

    @Column(name = "total_horas")
    private int totalHoras;

    @Column(name = "cobro")
    private double cobro;

}
