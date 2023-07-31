package com.example.todomanagement.service.impl;

import com.example.exception.ResourceNotFoundException;
import com.example.todomanagement.dto.TodoDto;
import com.example.todomanagement.entity.Todo;
import com.example.todomanagement.repository.TodoRepository;
import com.example.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl  implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //convert TodoDto into Jpa entity

        Todo todo = modelMapper.map(todoDto,Todo.class);

        //Todo jpa entity
        Todo savedTodo = todoRepository.save(todo);

        //convert saved Todo jpa entity object into TodoDto object

        TodoDto savedTodoDto = modelMapper.map(savedTodo,TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id :" + id));

        return modelMapper.map(todo,TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {

        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo,TodoDto.class))
                .collect(Collectors.toList());
    }
}
