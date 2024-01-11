package com.arllansantana.todolist;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// A anotação @Repository indica que esta interface é um repositório Spring Data JPA.
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    // O JpaRepository fornece métodos CRUD básicos, como save(), findById(), findAll(), count(), deleteById().

}
