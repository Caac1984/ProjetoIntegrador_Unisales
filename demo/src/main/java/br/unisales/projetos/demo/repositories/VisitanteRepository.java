package br.unisales.projetos.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unisales.projetos.demo.models.Visitante;

public interface VisitanteRepository extends MongoRepository<Visitante, Long> {
    // Métodos personalizados podem ser adicionados aqui.
}
