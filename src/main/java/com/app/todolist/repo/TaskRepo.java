package com.app.todolist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.todolist.model.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long>{

}
