package com.mballen.curso.boot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TB_DEPARTAMENTO")
public class Departamento extends AbstractEntity<Long, Number>{

    @Column(name = "NO_DEPARTAMENTO", unique = true, length = 60)
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Cargo> cargos;
}
