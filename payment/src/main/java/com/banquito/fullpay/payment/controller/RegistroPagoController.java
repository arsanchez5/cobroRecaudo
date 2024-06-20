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

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<RegistroPago>> getByEstado(@PathVariable String estado) {
        try {
            List<RegistroPago> registros = this.service.obtainByEstado(estado);
            return ResponseEntity.ok(registros);
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

}
