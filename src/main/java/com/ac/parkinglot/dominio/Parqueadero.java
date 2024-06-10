package com.ac.parkinglot.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(schema = "parqueadero")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plazas_carros", nullable = false)
    private Long plazasCarros;

    @Column(name = "plazas_motos", nullable = false)
    private Long plazasMotos;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "total_dia_ganado")
    private Long totalDiaGanancias;
}
