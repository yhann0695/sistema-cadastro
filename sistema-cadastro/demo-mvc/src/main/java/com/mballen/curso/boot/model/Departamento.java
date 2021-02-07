package com.mballen.curso.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TB_DEPARTAMENTO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_DEPARTAMENTO")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "NO_DEPARTAMENTO", unique = true, length = 60)
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Cargo> cargos;
}
