package com.springmvc.todos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by novy on 31.10.14.
 */
@Entity
@Data
@NoArgsConstructor
public class Todo {

    public static enum Status {
        ACTIVE, ARCHIVE
    }

    public static enum Priority {
        LOW, NORMAL, HIGH
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Priority priority = Priority.NORMAL;

    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.ACTIVE;
}
