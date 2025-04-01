package com.cassio.to_do_list.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private ToDo toDo;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ToDoList list;

}
