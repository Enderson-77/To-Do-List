package com.cassio.to_do_list.controller;

import com.cassio.to_do_list.dto.ReplacementDTO;
import com.cassio.to_do_list.dto.ToDoRequestDTO;
import com.cassio.to_do_list.dto.ToDoResponseDTO;
import com.cassio.to_do_list.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/to-do-list")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDoResponseDTO> getAll() {
        return toDoService.getAll();
    }

    @PostMapping
    public void saveTask(@RequestBody ToDoRequestDTO data) {
        toDoService.saveTask(data);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        toDoService.deleteTaskById(id);
    }

    @PostMapping(value = "/replacement")
    public void move(@RequestBody ReplacementDTO body) {
        toDoService.move(body.listId(), body.sourceIndex(), body.destinationIndex());
    }

}
