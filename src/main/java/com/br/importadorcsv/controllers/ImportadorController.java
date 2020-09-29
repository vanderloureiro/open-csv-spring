package com.br.importadorcsv.controllers;

import java.util.List;

import com.br.importadorcsv.models.Telefone;
import com.br.importadorcsv.services.ImportadorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
}