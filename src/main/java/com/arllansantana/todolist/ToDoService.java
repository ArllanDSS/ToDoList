package com.arllansantana.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// A anotação @Service indica que esta classe é um serviço Spring.
@Service
public class ToDoService {

    // Injeção de dependência do repositório ToDo.
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // Método para buscar todas as tarefas.
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    // Método para buscar uma tarefa pelo ID.
    public Optional<ToDo> findById(Long id) {
        return toDoRepository.findById(id);
    }

    // Método para salvar uma nova tarefa.
    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    // Método para atualizar uma tarefa existente.
    public ToDo update(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    // Método para excluir uma tarefa pelo ID.
    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }
}
