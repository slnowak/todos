package com.springmvc.todos.persistence;

import com.springmvc.todos.model.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by novy on 31.10.14.
 */
@Repository
public class HibernateTodoDao implements TodoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Todo> findAll() {
        return getCurrentSession()
                .createCriteria(Todo.class)
                .list();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
