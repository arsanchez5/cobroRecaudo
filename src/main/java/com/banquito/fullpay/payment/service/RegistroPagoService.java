package com.banquito.fullpay.payment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.payment.model.RegistroPago;
import com.banquito.fullpay.payment.repository.RegistroPagoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegistroPagoService {

    private final RegistroPagoRepository repository;

    public RegistroPagoService(RegistroPagoRepository repository) {
        this.repository = repository;
    }

    @Transactional(Transactional.TxType.NEVER)
    public RegistroPago obtainById(Long id) {
        Optional<RegistroPago> registroOpt = this.repository.findById(id);
        if (registroOpt.isPresent()) {
            return registroOpt.get();
        } else {
            throw new RuntimeException("No existe el registro con id: " + id);
        }
    }

    public RegistroPago create(RegistroPago registroPago) {
        registroPago.setFechaPago(LocalDateTime.now());
        RegistroPago newRegistro = this.repository.save(registroPago);
        return newRegistro;
    }

    public List<RegistroPago> obtainAllRegistroPago(){
        return this.repository.findAll();
    }

}
