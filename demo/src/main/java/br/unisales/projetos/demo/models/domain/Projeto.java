package br.unisales.projetos.demo.models.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("projetos")
public class Projeto {
    @Id
    // private String id;
    // private String descricao;
    // private String professorRepresentante;

    // public String getId() {
    //     return id;
    // }

    // public void setId(String id) {
    //     this.id = id;
    // }

    // public String getDescricao() {
    //     return descricao;
    // }

    // public void setDescricao(String descricao) {
    //     this.descricao = descricao;
    // }

    // public String getProfessorRepresentante() {
    //     return professorRepresentante;
    // }

    // public void setProfessorRepresentante(String professorRepresentante) {
    //     this.professorRepresentante = professorRepresentante;
    // }

    private String id;
    private String nome;
    private String descricao;

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}