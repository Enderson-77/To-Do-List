package com.cassio.to_do_list.controller;

import com.cassio.to_do_list.dto.ToDoResponseDTO;
import com.cassio.to_do_list.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
