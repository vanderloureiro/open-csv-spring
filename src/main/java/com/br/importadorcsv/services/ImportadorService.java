package com.br.importadorcsv.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.br.importadorcsv.models.Telefone;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImportadorService {

    public ImportadorService() {
    }

    public List<Telefone> importarCsv(MultipartFile file) {

        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader reader   = new BufferedReader(new InputStreamReader(inputStream));

            List<Telefone> lista = new CsvToBeanBuilder<Telefone>(reader)
                .withType(Telefone.class)
                .build().parse();

            return lista;
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    
}