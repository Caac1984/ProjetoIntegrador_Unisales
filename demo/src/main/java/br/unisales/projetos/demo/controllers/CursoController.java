package br.unisales.projetos.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unisales.projetos.demo.models.Curso;
import br.unisales.projetos.demo.repositories.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    // Endpoint para salvar um novo curso
    @PostMapping
    public ResponseEntity<Curso> salvarCurso(@RequestBody Curso curso) {
        Curso salvo = cursoRepository.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
