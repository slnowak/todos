package com.springmvc.todos.controllers;

import com.springmvc.todos.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by novy on 31.10.14.
 */

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTodos(Model model) {
        model.addAttribute(
                "todos", todoService.findAll()
        );

        return "todos";
    }

}
