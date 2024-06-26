package com.banquito.fullpay.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.fullpay.payment.model.Recaudo;

@Repository
public interface RecaudoRepository extends JpaRepository<Recaudo, Long> {

}
