package com.ac.parkinglot.controlador;

import com.ac.parkinglot.dto.VehiculoDto;
import com.ac.parkinglot.servicio.VehiculoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/vehicle/")
public class VehiculoController {

    @Autowired
    private VehiculoServicio vehiculoServicio;

    @GetMapping(value = "buscarPorId", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarPorId(@RequestParam Long vehiculoId){
        try {
            return ResponseEntity.ok().body(vehiculoServicio.buscarPorId(vehiculoId));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(value = "listarTodos", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listarTodos(){
        try {
            return ResponseEntity.ok().body(vehiculoServicio.buscarTodos());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping(value = "ingresar", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ingresarVehiculo(@Valid @RequestBody VehiculoDto vehiculoDTO){
        try {
            return ResponseEntity.ok().body(vehiculoServicio.ingresarVehiculo(vehiculoDTO));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping(value = "modificar", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modificarVehiculo(@Valid @RequestBody VehiculoDto vehiculoDTO){
        try {
            return ResponseEntity.ok().body(vehiculoServicio.ingresarVehiculo(vehiculoDTO));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping(value = "generarCobro", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generarCobroSalidaVehiculo(@Valid @RequestBody VehiculoDto vehiculoDTO){
        try {
            return ResponseEntity.ok().body(vehiculoServicio.generarCobroSalidaVehiculo(vehiculoDTO));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "eliminar", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar( @RequestParam Long vehiculoId ){
        try {
            vehiculoServicio.eliminarVehiculo(vehiculoId);
            return ResponseEntity.ok().body(HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
