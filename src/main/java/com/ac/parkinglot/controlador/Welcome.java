package com.ac.parkinglot.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/welcome")
public class Welcome {

    @GetMapping(value = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bienvenida(@RequestParam Long vehiculoId){
        try {
            return ResponseEntity.ok().body("Welcome");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
