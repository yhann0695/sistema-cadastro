package com.mballen.curso.boot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_CARGO")
public class Cargo extends AbstractEntity<Long, Number>{

    @Column(name = "NO_CARGO", unique = true, length = 60)
    @NotNull
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CO_DEPARTAMENTO")
    private Departamento departamento;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;
}
