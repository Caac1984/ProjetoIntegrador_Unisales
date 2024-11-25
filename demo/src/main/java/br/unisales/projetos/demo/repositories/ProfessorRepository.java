package br.unisales.projetos.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unisales.projetos.demo.models.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, Long> {
    // Métodos personalizados podem ser adicionados aqui.
}
