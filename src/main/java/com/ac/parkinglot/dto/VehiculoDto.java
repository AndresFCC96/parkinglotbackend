package com.ac.parkinglot.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoDto {

    private Long id;

    @NotNull(message = "La placa del vehiculo no puede estar vacia")
    @Size(min = 1, max = 1, message = "La placa del vehiculo debe contener 6 caracteres")
    private String placa;

    @NotNull(message = "El tipo de vehiculo no puede estar vacio")
    @Size(min = 1, max = 1, message = "El tipo de vehiculo debe contener al menos un caracter")
    private String tipoVehiculo;

    private String modelo;

    private boolean descuento;

    private LocalDateTime fechaEntrada;

    private LocalDateTime fechaSalida;

    @NotNull(message = "Debe introducir la plaza del vehiculo")
    private int plaza;

    private int totalHoras;

    private double cobro;

}
