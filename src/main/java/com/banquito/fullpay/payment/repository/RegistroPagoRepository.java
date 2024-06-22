package com.banquito.fullpay.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.fullpay.payment.model.RegistroPago;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistroPagoRepository extends JpaRepository<RegistroPago, Long> {

    List<RegistroPago> findByEstado(String estado);

    List<RegistroPago> findByFechaPago(LocalDateTime fechaPago);
    
}
