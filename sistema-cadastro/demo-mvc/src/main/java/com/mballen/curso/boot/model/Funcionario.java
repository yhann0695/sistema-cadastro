package com.mballen.curso.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

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


    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(name = "SL_FUNCIONARIO", columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    @NotNull
    private BigDecimal salario;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "DT_ENTRADA", columnDefinition = "DATE")
    @NotNull
    private LocalDate dataEntrada;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "DT_SAIDA", columnDefinition = "DATE")
    private LocalDate dataSaida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CO_ENDERECO")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "CO_CARGO")
    private Cargo cargo;
}
