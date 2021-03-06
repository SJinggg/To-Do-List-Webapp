package me.sjinggg.webappplayground.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import me.sjinggg.webappplayground.data.ToDo;

public interface ToDoRepository extends MongoRepository<ToDo, String> {

}
