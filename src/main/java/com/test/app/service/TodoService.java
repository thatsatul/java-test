package com.test.app.service;

import com.test.app.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    private final Map<Long, Todo> todos = new HashMap<>();
    private Long currentId = 1L;

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos.values());
    }

    public Todo addTodo(String title) {
        Todo todo = new Todo(currentId, title, false);
        todos.put(currentId, todo);
        currentId++;
        return todo;
    }

    public boolean deleteTodo(Long id) {
        return todos.remove(id) != null;
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo existing = todos.get(id);
        if (existing != null) {
            if (updatedTodo.getTitle() != null) {
                existing.setTitle(updatedTodo.getTitle());
            }
            existing.setCompleted(updatedTodo.isCompleted());
            return existing;
        }
        return null;
    }
}
