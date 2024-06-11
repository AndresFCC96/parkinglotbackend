package com.ac.parkinglot.utils;

import java.time.LocalDateTime;

public class Utils {

    public static final String CARRO = "C";
    public static final String MOTO = "M";

    public static final String VEHICULO_ELECTRICO = "electrico";
    public static final String VEHICULO_HIBRIDO = "hibrido";

    public static final int TARIFA_MOTOS = 62;
    public static final int TARIFA_CARROS = 120;

    public static final int MAXIMO_MOTOS = 62;
    public static final int MAXIMO_CARROS = 120;

    public static final String ENTRADA = "entrada";
    public static final String SALIDA = "salida";

    public static String primerLetraMayuscula(String palabra){
        String mayuscula = palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
        return mayuscula;
    }

    public static int totalHoras(LocalDateTime fechaEntrada, LocalDateTime fechaSalida){
        return fechaSalida.getHour() - fechaEntrada.getHour();
    }

    public static double cobro(String tipo, String modelo, int totalHoras){
        double cobro = 0;
        if (modelo.equals(VEHICULO_ELECTRICO) ||
                modelo.equals(VEHICULO_HIBRIDO)){
            if(tipo.equals(CARRO)){
                cobro = (totalHoras*120 - ((totalHoras*120) * 0.25) );
                return cobro;
            }else{
                cobro = (totalHoras*62 - ((totalHoras*62) * 0.25) );
                return cobro;
            }
        }else{
            if(tipo.equals(CARRO)){
                cobro = (totalHoras*120);
                return cobro;
            }else{
                cobro = (totalHoras*62);
                return cobro;
            }
        }
    }

    public static boolean validarFecha(LocalDateTime fechaAValidar){
        LocalDateTime actual = LocalDateTime.now();
        if(fechaAValidar.getDayOfMonth() == actual.getDayOfMonth() &&
            fechaAValidar.getMonth() == actual.getMonth() &&
                fechaAValidar.getYear() == actual.getYear()){
            return true;
        }
        return false;
    }
}
