package com.springmvc.todos.persistence;

import com.mysema.query.types.expr.BooleanExpression;
import com.springmvc.todos.model.QTodo;
import com.springmvc.todos.model.Todo;

/**
 * Created by novy on 31.10.14.
 */
public class TodoSpecification {

    private final static QTodo todo = QTodo.todo;

    public static BooleanExpression withDescriptionContaining(String expression) {
        return todo.description.contains(expression);
    }

    public static BooleanExpression withActiveStatus() {
        return todo.status.eq(Todo.Status.ACTIVE);
    }

    public static BooleanExpression withHighPriority() {
        return todo.priority.eq(Todo.Priority.HIGH);
    }
}
