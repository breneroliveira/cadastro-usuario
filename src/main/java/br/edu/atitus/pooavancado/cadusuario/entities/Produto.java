package br.edu.atitus.pooavancado.cadusuario.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto extends GenericEntity {

    @Column(nullable = false)
    private Double valorUnitario;

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}