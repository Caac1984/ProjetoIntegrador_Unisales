package br.unisales.projetos.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unisales.projetos.demo.models.Grupo;
import br.unisales.projetos.demo.repositories.GrupoRepository;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    // Endpoint para salvar um novo grupo
    @PostMapping
    public ResponseEntity<Grupo> salvarGrupo(@RequestBody Grupo grupo) {
        Grupo salvo = grupoRepository.save(grupo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
