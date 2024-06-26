package com.banquito.fullpay.payment.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "COR_COBRO_RECAUDO")
public class CobroRecaudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COBRO_RECAUDO", nullable = false)
    private Long id;
    @Column(name = "COD_EMPRESA", nullable = false)
    private Long codEmpresa;
    @Column(name = "COD_CUENTA", nullable = false)
    private Long codCuenta;
    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    @Column(name = "TIPO", length = 3, nullable = false)
    private String tipo;
    @Column(name = "VALOR", precision = 17, scale = 2, nullable = false)
    private BigDecimal valor;
    @Column(name = "ESTADO", nullable = false)
    private String estado;
    @Column(name = "FRECUENCIA", length = 3)
    private String frecuencia;

    public CobroRecaudo(Long id) {
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
        CobroRecaudo other = (CobroRecaudo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}