package com.ac.parkinglot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParqueaderoDto {

    private Long id;

    @NotNull(message = "El numero de plazas disponibles para carros tiene que ser mayor a cero")
    private Long plazasCarros;

    @NotNull(message = "El numero de plazas disponibles para motos tiene que ser mayor a cero")
    private Long plazasMotos;

    @NotNull(message = "Debe ingresar la fecha del dia")
    private Date fecha;

    private Long totalDiaGanancias;
}
