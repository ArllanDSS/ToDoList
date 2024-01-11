package com.arllansantana.todolist;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


// A anotação @Entity indica que esta classe é uma entidade JPA.
@Entity
// A anotação @Data do Lombok gera automaticamente getters, setters, equals(), hashCode() e toString().
@Data
public class ToDo {

    // A anotação @Id indica que este campo é a chave primária da entidade.
    // A anotação @GeneratedValue permite que o banco de dados gere automaticamente o valor.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private Boolean completed = false;
}