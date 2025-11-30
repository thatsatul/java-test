package com.test.app.repository;

import com.test.app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // JpaRepository provides basic CRUD operations automatically:
    // - save(todo) -> saves or updates
    // - findAll() -> gets all todos
    // - findById(id) -> gets todo by ID
    // - deleteById(id) -> deletes todo by ID
    // - existsById(id) -> checks if todo exists
}
