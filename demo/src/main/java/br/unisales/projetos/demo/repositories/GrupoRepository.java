package br.unisales.projetos.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unisales.projetos.demo.models.Grupo;

public interface GrupoRepository extends MongoRepository<Grupo, Long> {
    // Métodos personalizados podem ser adicionados aqui.
}
