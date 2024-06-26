package com.banquito.fullpay.payment.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "COR_RECAUDO", schema = "cobrosrecaudos")
public class Recaudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_RECAUDO")
    private Long codRecaudo;

    @Column(name = "COD_COBRO")
    private Long corCodCobro;

    @Column(name = "COD_REGISTRO_PAGO")
    private Long corCodRegistroPago;

    @ManyToOne
    @JoinColumn(name = "COD_REGISTRO_PAGO", referencedColumnName = "COD_REGISTRO_PAGO", insertable = false, updatable = false)
    private RegistroPago registroPago;

    public Recaudo(Long codRecaudo) {
        this.codRecaudo = codRecaudo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codRecaudo == null) ? 0 : codRecaudo.hashCode());
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
        Recaudo other = (Recaudo) obj;
        if (codRecaudo == null) {
            if (other.codRecaudo != null)
                return false;
        } else if (!codRecaudo.equals(other.codRecaudo))
            return false;
        return true;
    }

}