package com.app.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.todolist.model.Task;
import com.app.todolist.service.TaskService;

@RestController
@RequestMapping("/todo")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public ResponseEntity<List<Task>> getTasks(){
		return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTask(@PathVariable Long id){
		return new ResponseEntity<>(taskService.getTaskByID(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
		taskService.updateTask(id, task);
		return new ResponseEntity<>(taskService.getTaskByID(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable Long id){
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
