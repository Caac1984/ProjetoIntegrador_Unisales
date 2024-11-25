package br.unisales.projetos.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unisales.projetos.demo.models.Visitante;
import br.unisales.projetos.demo.repositories.VisitanteRepository;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteRepository visitanteRepository;

    // Endpoint para salvar um novo visitante
    @PostMapping
    public ResponseEntity<Visitante> salvarVisitante(@RequestBody Visitante visitante) {
        Visitante salvo = visitanteRepository.save(visitante);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
