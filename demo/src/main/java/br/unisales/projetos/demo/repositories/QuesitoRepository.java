// Local: src/main/java/br/unisales/projetos/demo/repositories/QuesitoRepository.java
package br.unisales.projetos.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.unisales.projetos.demo.models.domain.Quesito;

public interface QuesitoRepository extends MongoRepository<Quesito, String> {
    // Aqui você pode adicionar consultas customizadas, se necessário
}
