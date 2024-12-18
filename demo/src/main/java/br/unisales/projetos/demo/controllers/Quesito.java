package br.unisales.projetos.demo.controllers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quesitos") // Especifique o nome da coleção, se necessário
public class Quesito {
    @Id
    private String id; // Certifique-se de que existe um campo para o identificador

    private String nome;
    private String descricao;

    // Getters e setters
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
