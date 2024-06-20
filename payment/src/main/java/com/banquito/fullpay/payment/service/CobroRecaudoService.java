package com.banquito.fullpay.payment.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.payment.model.CobroRecaudo;
import com.banquito.fullpay.payment.repository.CobroRecaudoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CobroRecaudoService {

    private final CobroRecaudoRepository repository;

    public CobroRecaudoService(CobroRecaudoRepository repository) {
        this.repository = repository;
    }

    @Transactional(Transactional.TxType.NEVER)
    public CobroRecaudo obtainById(Long id) {
        Optional<CobroRecaudo> cobroOpt = this.repository.findById(id);
        if (cobroOpt.isPresent()) {
            return cobroOpt.get();
        } else {
            throw new RuntimeException("No existe el cobro con id: " + id);
        }
    }

    public List<CobroRecaudo> obtainByTipo(String tipo) {
        return this.repository.findByTipo(tipo);
    }

    public void updateValor(Long id, BigDecimal newValue) {
        CobroRecaudo cobroRecaudo = obtainById(id);
        cobroRecaudo.setValor(newValue);
        this.repository.save(cobroRecaudo);
    }

}