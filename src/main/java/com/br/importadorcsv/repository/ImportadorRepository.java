package com.br.importadorcsv.repository;

import java.util.ArrayList;
import java.util.List;

import com.br.importadorcsv.models.Telefone;

import org.springframework.stereotype.Repository;

@Repository
public class ImportadorRepository {

    /**
     * Método que retorna dados estáticos 
     * apenas para estudo de exportacao de csv
     */
    public List<Telefone> findAll() {
        List<Telefone> lista = new ArrayList<>();
        lista.add(new Telefone("88", "994949494", "maria", "russas", "CE"));
        lista.add(new Telefone("85", "992929292", "lúcio", "fortaleza", "CE"));
        lista.add(new Telefone("84", "991919191", "luzia", "mossoró", "RN"));
        lista.add(new Telefone("85", "995695695", "leonardo", "horizonte", "CE"));
        return lista;
    }
}