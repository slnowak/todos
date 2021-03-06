package com.springmvc.todos.services;

import com.google.common.collect.Lists;
import com.mysema.query.types.Predicate;
import com.springmvc.todos.model.Todo;
import com.springmvc.todos.persistence.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by novy on 31.10.14.
 */

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Override
    public Collection<Todo> findAll() {
        return todoDao.findAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Todo> findAll(Predicate predicate) {
        return Lists.newArrayList(todoDao.findAll(predicate));
    }
}
