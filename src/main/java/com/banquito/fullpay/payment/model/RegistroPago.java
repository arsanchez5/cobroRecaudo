package com.banquito.fullpay.payment.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "COR_REGISTRO_PAGO")
public class RegistroPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_REGISTRO_PAGO", nullable = false)
    private Long id;
    @Column(name = "NUMERO_CONTRAPARTIDA", length = 20, nullable = false)
    private String numeroContrapartida;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_PAGO", nullable = false)
    private LocalDateTime fechaPago;
    @Column(name = "MONTO", precision = 17, scale = 2, nullable = false)
    private BigDecimal monto;
    @Column(name = "CUENTA_DESTINO", length = 10, nullable = false)
    private String cuentaDestino;
    @Column(name = "TIPO_TRANSACCION", length = 3)
    private String tipoTransaccion;
    @Column(name = "CANAL", length = 3)
    private String canal;

    @ManyToOne
    @JoinColumn(name = "COD_COBRO_RECAUDO", referencedColumnName = "COD_COBRO_RECAUDO", insertable = false, updatable = false)
    private CobroRecaudo cobroRecaudo;

    public RegistroPago(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
