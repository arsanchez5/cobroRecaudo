package com.banquito.fullpay.payment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.fullpay.payment.model.Recaudo;
import com.banquito.fullpay.payment.service.RecaudoService;

@RestController
@RequestMapping(path = "/recaudo")
public class RecaudoController {

    private final RecaudoService service;

    public RecaudoController(RecaudoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Recaudo>> getAll() {
        try {
            List<Recaudo> cobros = this.service.obtainAllCobroRecaudo();
            return ResponseEntity.ok(cobros);
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recaudo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.service.obtainById(id));
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Recaudo> create(@RequestBody List<Recaudo> recaudos) {
        try {
            this.service.saveAll(recaudos);
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }


}
