package com.banquito.fullpay.payment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.fullpay.payment.model.CobroRecaudo;
import com.banquito.fullpay.payment.service.CobroRecaudoService;

@RestController
@RequestMapping(path = "/cobros")
public class CobroRecaudoController {

    private final CobroRecaudoService service;

    public CobroRecaudoController(CobroRecaudoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CobroRecaudo>> getAll() {
        try {
            List<CobroRecaudo> cobros = this.service.obtainAllCobroRecaudo();
            return ResponseEntity.ok(cobros);
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CobroRecaudo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.service.obtainById(id));
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<CobroRecaudo>> getByTipo(@PathVariable String tipo) {
        try {
            List<CobroRecaudo> cobros = this.service.obtainByTipo(tipo);
            return ResponseEntity.ok(cobros);
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<CobroRecaudo>> getByEstado(@PathVariable String estado){
        try {
            List<CobroRecaudo> cobros = this.service.obtainByEstado(estado);
            return ResponseEntity.ok(cobros);
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

}
