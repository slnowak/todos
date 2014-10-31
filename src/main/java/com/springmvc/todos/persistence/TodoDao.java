package com.springmvc.todos.persistence;

import com.springmvc.todos.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by novy on 31.10.14.
 */
public interface TodoDao extends JpaRepository<Todo, Integer> {
}
