// Local: src/main/java/br/unisales/projetos/demo/controllers/QuesitoController.java
package br.unisales.projetos.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.unisales.projetos.demo.repositories.QuesitoRepository;

import java.util.List;

@RestController
@RequestMapping("/quesitos")
public class QuesitoController {

    @Autowired
    private QuesitoRepository quesitoRepository;

    // Endpoint para listar todos os quesitos
    @GetMapping
    public ResponseEntity<List<br.unisales.projetos.demo.repositories.Quesito>> listarQuesitos() {
        List<br.unisales.projetos.demo.repositories.Quesito> quesitos = quesitoRepository.findAll();
        return ResponseEntity.ok(quesitos);
    }

    // Endpoint para salvar um novo quesito
    /**
     * @param <S>
     * @param quesito
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping
    public <S> ResponseEntity<Quesito> salvarQuesito(@RequestBody Quesito quesito) {
        Quesito salvo = quesitoRepository.saveAll((Iterable<S>) quesito);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // Endpoint para buscar um quesito por ID
    @GetMapping("/{id}")
    public ResponseEntity<br.unisales.projetos.demo.repositories.Quesito> buscarQuesitoPorId(@PathVariable String id) {
        return quesitoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar um quesito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuesito(@PathVariable String id) {
        if (quesitoRepository.existsById(id)) {
            quesitoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
