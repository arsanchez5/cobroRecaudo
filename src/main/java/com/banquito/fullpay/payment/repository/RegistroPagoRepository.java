package com.banquito.fullpay.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.fullpay.payment.model.RegistroPago;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistroPagoRepository extends JpaRepository<RegistroPago, Long> {

    List<RegistroPago> findByFechaPago(LocalDateTime fechaPago);

}
