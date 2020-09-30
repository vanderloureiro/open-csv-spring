package com.br.importadorcsv.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import com.br.importadorcsv.models.Telefone;
import com.br.importadorcsv.repository.ImportadorRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImportadorService {

    private ImportadorRepository repository;

    public ImportadorService(ImportadorRepository repository) {
        this.repository = repository;
    }

    public List<Telefone> importarCsv(MultipartFile file) {

        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return new CsvToBeanBuilder<Telefone>(reader).withType(Telefone.class).build().parse();
        } catch (IOException e) {
            return null;
        }
    }

    public void exportarCsv(PrintWriter writer) {
        List<Telefone> telefones = this.repository.findAll();

        try {
            StatefulBeanToCsv<Telefone> beanToCsv = new StatefulBeanToCsvBuilder<Telefone>(writer)
            .build();

            beanToCsv.write(telefones);
            writer.close();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    
}