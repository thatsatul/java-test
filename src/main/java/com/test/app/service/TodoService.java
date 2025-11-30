package com.test.app.service;

import com.test.app.model.Todo;
import com.test.app.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // Constructor injection - Spring automatically provides the repository
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll(); // Gets all todos from database
    }

    public Todo addTodo(String title) {
        Todo todo = new Todo(null, title, false); // ID will be auto-generated
        return todoRepository.save(todo); // Saves to database and returns saved todo
    }

    public boolean deleteTodo(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id); // Deletes from database
            return true;
        }
        return false;
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Optional<Todo> existingOptional = todoRepository.findById(id);
        if (existingOptional.isPresent()) {
            Todo existing = existingOptional.get();
            if (updatedTodo.getTitle() != null) {
                existing.setTitle(updatedTodo.getTitle());
            }
            existing.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(existing); // Saves updated todo to database
        }
        return null;
    }
}
