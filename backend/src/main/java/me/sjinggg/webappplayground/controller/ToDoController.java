package me.sjinggg.webappplayground.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.sjinggg.webappplayground.service.ToDoService;
import me.sjinggg.webappplayground.data.ToDo;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
  @Autowired
  private ToDoService toDoService;

  @GetMapping
  public List<ToDo> findAll(){
    return toDoService.findAll();
  }

  @GetMapping("/{id}")
  public ToDo findById(String id){
    return toDoService.findById(id);
  }

  @PostMapping
  public ToDo create(@RequestBody ToDo todo){
    return toDoService.save(todo);
  }

  @PutMapping("/{id}")
  public ToDo update(@RequestBody ToDo todo){
    return toDoService.save(todo);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable String id){
    toDoService.deleteById(id);
  }
}
