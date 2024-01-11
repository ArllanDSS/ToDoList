package com.arllansantana.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A anotação @RestController indica que esta classe é um controlador REST.
@RestController
@RequestMapping("/todos")
public class ToDoController {

    // Injeção de dependência do serviço ToDo.
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // Método para buscar todas as tarefas.
    @GetMapping
    public ResponseEntity<List<ToDo>> findAll() {
        return new ResponseEntity<>(toDoService.findAll(), HttpStatus.OK);
    }

    // Método para buscar uma tarefa pelo ID.
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable Long id) {
        return toDoService.findById(id)
                .map(todo -> new ResponseEntity<>(todo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Método para salvar uma nova tarefa.
    @PostMapping
    public ResponseEntity<ToDo> save(@RequestBody ToDo toDo) {
        return new ResponseEntity<>(toDoService.save(toDo), HttpStatus.CREATED);
    }

    // Método para atualizar uma tarefa existente.
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@PathVariable Long id, @RequestBody ToDo toDo) {
        return toDoService.findById(id)
                .map(todo -> {
                    todo.setTitle(toDo.getTitle());
                    todo.setDescription(toDo.getDescription());
                    todo.setCompleted(toDo.getCompleted());
                    return new ResponseEntity<>(toDoService.save(todo), HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Método para excluir uma tarefa pelo ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        toDoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
