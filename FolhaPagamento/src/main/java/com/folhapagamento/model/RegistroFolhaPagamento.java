package com.folhapagamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor	
public class RegistroFolhaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empresa;
    private int mes;
    private int ano;
    private String nome;
    private String cargo;
    private String lotacao;
    private String admissao;
    private String nascimento;
    private double vencimentos;
    private double encargos;
    private double beneficios;
    private double outrasRemuneracoes;
    private String vinculo;
    private String detalheVinculo;
    private String liminar;
    private int arquivoId;

}

