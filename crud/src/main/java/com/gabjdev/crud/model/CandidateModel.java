// Define o pacote ao qual esta classe pertence.
package com.gabjdev.crud.model;

// Importa as anotações necessárias para a persistência de dados.

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Anotação que indica que esta classe é uma entidade no contexto da persistência de dados.
@Entity
public class CandidateModel {
    // Anotação que indica que este campo é a chave primária da entidade.
    @Id
    // Anotação que indica que o valor do ID deve ser gerado automaticamente.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name; // Campo para o nome do candidato.
    private String position; // Campo para a posição do candidato.
    private String informationPersonal; // Campo para informações pessoais do candidato.
    private String skills; // Campo para as habilidades do candidato.

    // Métodos getters e setters para cada campo, permitindo a leitura e alteração dos valores.
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInformationPersonal() {
        return informationPersonal;
    }

    public void setInformationPersonal(String informationPersonal) {
        this.informationPersonal = informationPersonal;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
