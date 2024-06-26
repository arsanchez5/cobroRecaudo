package com.banquito.fullpay.payment.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "COR_REGISTRO_PAGO", schema = "cobrosrecaudos")
public class RegistroPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_REGISTRO_PAGO")
    private Long codRegistroPago;

    @Column(name = "NUMERO_CONTRAPARTIDA", length = 20)
    private String numeroContrapartida;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_PAGO")
    private LocalDateTime fechaPago;

    @Column(name = "MONTO", precision = 17, scale = 2)
    private BigDecimal monto;

    @Column(name = "METODO_PAGO", length = 3)
    private String metodoPago;

    public RegistroPago(Long codRegistroPago) {
        this.codRegistroPago = codRegistroPago;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codRegistroPago == null) ? 0 : codRegistroPago.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RegistroPago other = (RegistroPago) obj;
        if (codRegistroPago == null) {
            if (other.codRegistroPago != null)
                return false;
        } else if (!codRegistroPago.equals(other.codRegistroPago))
            return false;
        return true;
    }
    
}
