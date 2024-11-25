package br.unisales.projetos.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("quesitos")
public class Quesito {

    @Id
    private String id;
    @Indexed(unique = true)
    private String nometrabalho;
    private String descricao;
    private String matricula;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNometrabalho() {
        return nometrabalho;
    }
    public void setNometrabalho(String nometrabalho) {
        this.nometrabalho = nometrabalho;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
