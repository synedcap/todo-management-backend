package com.example.todomanagement.controller;


import com.example.todomanagement.dto.TodoDto;
import com.example.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    //build add todo rest api
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    //build get todo rest api
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){

        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    //build get All todo rest api
    @GetMapping()
    public ResponseEntity<List<TodoDto>> getAllTodo(){

        List<TodoDto> todos = todoService.getAllTodos();
        return  ResponseEntity.ok(todos);

    }

    //build update todo rest api
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){

        TodoDto updatedTodo = todoService.updateTodo(todoDto,todoId);
        return  ResponseEntity.ok(updatedTodo);

    }

    //build update todo rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){

        todoService.deleteTodo(todoId);
        return  ResponseEntity.ok("Todo deleted successfully!");

    }

}
