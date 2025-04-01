package com.cassio.to_do_list.entity;

import com.cassio.to_do_list.dto.ToDoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_todo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    public ToDo(ToDoRequestDTO data) {
        this.text = data.text();
    }

}
