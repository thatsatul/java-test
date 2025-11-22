package com.test.app.controller;

import com.test.app.model.Todo;
import com.test.app.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*") // allows testing from browser or frontend
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo.getTitle());
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        boolean removed = todoService.deleteTodo(id);
        return removed ? "Todo deleted" : "Todo not found";
    }

    @PutMapping("/{id}")
    public Object updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Todo updated = todoService.updateTodo(id, todo);
        if (updated == null) {
            return "Todo not found";
        }
        return updated;
    }
}
