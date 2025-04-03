package com.cassio.to_do_list.service;

import com.cassio.to_do_list.dto.ToDoRequestDTO;
import com.cassio.to_do_list.dto.ToDoResponseDTO;
import com.cassio.to_do_list.entity.ToDo;
import com.cassio.to_do_list.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repository;

    public List<ToDoResponseDTO> getAll() {
        List<ToDoResponseDTO> list = repository.findAllWithPosition();
        return list;
    }

    @Transactional
    public void saveTask(ToDoRequestDTO data) {
        ToDo toDoData = new ToDo(data);
        repository.save(toDoData);
    }

}
