package com.cassio.to_do_list.repository;

import com.cassio.to_do_list.dto.ToDoResponseDTO;
import com.cassio.to_do_list.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_todo.id, tb_todo.text, tb_belonging.position
            FROM tb_todo
            INNER JOIN tb_belonging ON tb_todo.id = tb_belonging.todo_id
            ORDER BY tb_belonging.position
            """)
    List<ToDoResponseDTO> findAllWithPosition();

}
