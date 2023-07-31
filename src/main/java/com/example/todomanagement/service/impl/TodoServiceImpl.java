package com.example.todomanagement.service.impl;

import com.example.todomanagement.dto.TodoDto;
import com.example.todomanagement.entity.Todo;
import com.example.todomanagement.repository.TodoRepository;
import com.example.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl  implements TodoService {

    private TodoRepository todoRepository;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //convert TodoDto into Jpa entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        //Todo jpa entity
        Todo savedTodo = todoRepository.save(todo);

        //convert saved Todo jpa entity object into TodoDto object
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());

        return savedTodoDto;
    }
}
