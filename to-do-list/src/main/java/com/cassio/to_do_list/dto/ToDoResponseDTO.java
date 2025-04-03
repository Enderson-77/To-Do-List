package com.cassio.to_do_list.dto;

import com.cassio.to_do_list.entity.ToDo;

public record ToDoResponseDTO(Long id, String text, Integer position) { }
