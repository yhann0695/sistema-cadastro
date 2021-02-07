package com.mballen.curso.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_CARGO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_CARGO")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "NO_CARGO", unique = true, length = 60)
    @NotNull
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CO_DEPARTAMENTO")
    private Departamento departamento;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;
}
