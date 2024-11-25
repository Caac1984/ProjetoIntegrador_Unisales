package br.unisales.projetos.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "professor")
public class Professor {
    @Id
    private Long id;
    private String nome;
    private String disciplina;

    // Construtores, Getters e Setters
    public Professor() {
    }

    public Professor(Long id, String nome, String disciplina) {
        this.id = id;
        this.nome = nome;
        this.disciplina = disciplina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
