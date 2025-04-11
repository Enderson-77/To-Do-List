package com.cassio.to_do_list.service;

import com.cassio.to_do_list.dto.ToDoRequestDTO;
import com.cassio.to_do_list.dto.ToDoResponseDTO;
import com.cassio.to_do_list.entity.ToDo;
import com.cassio.to_do_list.projection.ToDoProjection;
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
        ToDo toDoData = repository.save(new ToDo(data));

        Integer maxPosition = repository.findMaxPosition()+1;

        repository.updateTbBelonging(maxPosition, toDoData.getId());
    }

    @Transactional
    public void deleteTaskById(Long id) {
        repository.deleteBelongingByTodoId(id);
        repository.deleteById(id);
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<ToDoProjection> list = repository.searchByList(listId);

        ToDoProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            repository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
