package br.unisales.projetos.demo.repositories;

import br.unisales.projetos.demo.models.Quesito;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface QuesitoRepository extends MongoRepository<Quesito, String> {
    
    // Método para buscar quesitos pela descrição
    List<Quesito> findByDescricao(String descricao);
}
