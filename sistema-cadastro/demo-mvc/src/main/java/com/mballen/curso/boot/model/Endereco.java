package com.mballen.curso.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "TB_ENDERECO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_ENDERECO")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Column(name = "DS_LOGRADOURO")
    private String logradouro;

    @NotNull
    @Column(name = "DS_BAIRRO")
    private String bairro;

    @NotNull
    @Column(name = "NO_CIDADE")
    private String cidade;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "IC_DF", length = 2)
    private UF uf;

    @NotNull
    @Column(name = "DS_CEP", length = 9)
    private String cep;

    @NotNull
    @Column(name = "NU_ENDERECO", length = 5)
    private Integer numero;

    @Column(name = "CPTO_ENDERECO")
    private String complemento;
}
