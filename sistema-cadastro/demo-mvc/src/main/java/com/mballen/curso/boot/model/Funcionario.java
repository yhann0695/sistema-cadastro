package com.mballen.curso.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "TB_FUNCIONARIO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_FUNCIONARIO")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "NO_FUNCIONARIO")
    @NotNull
    private String nome;

    @NotNull
    @Column(name = "SL_FUNCIONARIO", columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal salario;

    @Column(name = "DT_ENTRADA", columnDefinition = "DATE")
    @NotNull
    private LocalDate dataEntrada;

    @Column(name = "DT_SAIDA", columnDefinition = "DATE")
    private LocalDate dataSaida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CO_ENDERECO")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "CO_CARGO")
    private Cargo cargo;
}
