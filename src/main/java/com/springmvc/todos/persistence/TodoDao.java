package com.springmvc.todos.persistence;

import com.springmvc.todos.model.Todo;

import java.util.Collection;

/**
 * Created by novy on 31.10.14.
 */
public interface TodoDao {

    Collection<Todo> findAll();
}
