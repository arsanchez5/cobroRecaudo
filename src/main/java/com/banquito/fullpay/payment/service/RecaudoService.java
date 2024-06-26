package com.banquito.fullpay.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.payment.model.Recaudo;
import com.banquito.fullpay.payment.repository.RecaudoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecaudoService {

    private final RecaudoRepository repository;

    public RecaudoService(RecaudoRepository repository) {
        this.repository = repository;
    }

    @Transactional(Transactional.TxType.NEVER)
    public Recaudo obtainById(Long id) {
        Optional<Recaudo> cobroOpt = this.repository.findById(id);
        if (cobroOpt.isPresent()) {
            return cobroOpt.get();
        } else {
            throw new RuntimeException("No existe el recaudo con id: " + id);
        }
    }

    public List<Recaudo> obtainAllCobroRecaudo(){
        return repository.findAll();
    }

    public Recaudo saveRecaudo(Recaudo recaudo) {
        return repository.save(recaudo);
    }

    @Transactional
    public void saveAll(List<Recaudo> recaudos) {
        repository.saveAll(recaudos);
    }


}