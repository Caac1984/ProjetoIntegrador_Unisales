package br.unisales.projetos.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unisales.projetos.demo.models.Curso;

public interface CursoRepository extends MongoRepository<Curso, Long> {
    // Métodos personalizados podem ser adicionados aqui.
}
