package br.unisales.projetos.demo.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.unisales.projetos.demo.models.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, Long> {
    // Você pode adicionar métodos personalizados de consulta, se necessário.
}
