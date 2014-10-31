package com.springmvc.todos.services;

import com.springmvc.todos.model.Todo;

import java.util.Collection;

/**
 * Created by novy on 31.10.14.
 */
public interface TodoService {

    Collection<Todo> findAll();
}
