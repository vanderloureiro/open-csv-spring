package com.br.importadorcsv.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.br.importadorcsv.models.Telefone;
import com.br.importadorcsv.services.ImportadorService;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@Api("Importador API")
@RequestMapping("/importador")
@RestController
public class ImportadorController {

    private ImportadorService importadorService;

    public ImportadorController(ImportadorService importadorService) {
        this.importadorService = importadorService;
    }

    @PostMapping
    public ResponseEntity<List<Telefone>> importarCsv(@RequestParam MultipartFile file) {
        return ResponseEntity.ok().body(this.importadorService.importarCsv(file));
    }

    @GetMapping(produces = "text/csv")
    public void exportarCsv(HttpServletResponse response) {

        try {

            response.setContentType("text/csv; charset=UTF-8");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=download.csv");
            this.importadorService.exportarCsv(response.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}