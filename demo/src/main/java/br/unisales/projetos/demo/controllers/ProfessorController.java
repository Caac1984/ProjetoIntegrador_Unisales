package br.unisales.projetos.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unisales.projetos.demo.models.Professor;
import br.unisales.projetos.demo.repositories.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    // Endpoint para salvar um novo professor
    @PostMapping
    public ResponseEntity<Professor> salvarProfessor(@RequestBody Professor professor) {
        Professor salvo = professorRepository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
