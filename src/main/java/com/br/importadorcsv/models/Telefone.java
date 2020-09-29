package com.br.importadorcsv.models;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class Telefone {
    
    @CsvBindByName(column = "ddd")
    private String ddd;

    @CsvBindByName(column = "numero")
    private String numero;

    @CsvBindByName(column = "nome")
    private String nome;

    @CsvBindByName(column = "cidade")
    private String cidade;

    @CsvBindByName(column = "uf")
    private String uf;
}