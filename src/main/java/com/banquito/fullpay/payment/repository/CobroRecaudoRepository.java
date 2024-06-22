package com.banquito.fullpay.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.fullpay.payment.model.CobroRecaudo;
import java.util.List;

public interface CobroRecaudoRepository extends JpaRepository<CobroRecaudo, Long> {

    List<CobroRecaudo> findByTipo(String tipo);

    List<CobroRecaudo> findByEstado(String estado);

}
