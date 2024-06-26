package com.banquito.fullpay.payment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.fullpay.payment.model.RegistroPago;
import com.banquito.fullpay.payment.service.RegistroPagoService;

@RestController
@RequestMapping(path = "/registros")
public class RegistroPagoController {

    private final RegistroPagoService service;

    public RegistroPagoController(RegistroPagoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroPago> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.service.obtainById(id));
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RegistroPago>> getAll() {
        try {
            List<RegistroPago> registros = this.service.obtainAllRegistroPago();
            return ResponseEntity.ok(registros);
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RegistroPago> create(@RequestBody RegistroPago registroPago) {
        try {
            RegistroPago newRegistro = this.service.create(registroPago);
            return ResponseEntity.ok(newRegistro);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }

}
