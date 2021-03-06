package me.sjinggg.webappplayground.data;

import org.springframework.data.annotation.Id;

public class ToDo {

  @Id
  private String id;
  private String title;
  private boolean completed;

  public ToDo(String title, boolean completed){
    this.title = title;
    this.completed = completed;
  }

  public String getId(){
    return this.id;
  }

  public String getTitle(){
    return this.title;
  }

  public Boolean isCompleted(){
    return this.completed;
  }
}