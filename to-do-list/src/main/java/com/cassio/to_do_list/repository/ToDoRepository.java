package com.cassio.to_do_list.repository;

import com.cassio.to_do_list.dto.ToDoResponseDTO;
import com.cassio.to_do_list.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    // GET method
    @Query(nativeQuery = true, value = """
            SELECT tb_todo.id, tb_todo.text, tb_belonging.position
            FROM tb_todo
            INNER JOIN tb_belonging ON tb_todo.id = tb_belonging.todo_id
            ORDER BY tb_belonging.position
            """)
    List<ToDoResponseDTO> findAllWithPosition();

    // POST method
    @Query(nativeQuery = true, value = """
            SELECT MAX(position) AS largest_value
            FROM tb_belonging;
            """)
    Integer findMaxPosition();

    @Modifying
    @Query(nativeQuery = true, value = """
            INSERT INTO tb_belonging (position, todo_id, list_id)
            VALUES (:maxPosition, :todoId, 1)
            """)
    void updateTbBelonging(@Param("maxPosition") Integer maxPosition, @Param("todoId") Long todoId);

    // DELETE method
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM tb_belonging WHERE tb_belonging.todo_id = :id")
    void deleteBelongingByTodoId(Long id);

}
