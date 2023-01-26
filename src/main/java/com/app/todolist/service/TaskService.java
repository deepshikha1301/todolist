package com.app.todolist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todolist.model.Task;
import com.app.todolist.repo.TaskRepo;

@Service
public class TaskService {

	private final TaskRepo taskrepo;
	
	public TaskService(TaskRepo taskrepo) {
		this.taskrepo = taskrepo;
	}
	
	public List<Task> getTasks(){
		List<Task> tasks = new ArrayList<>();
		taskrepo.findAll().forEach(tasks::add);
		return tasks;
	}
	
	public Task getTaskByID(Long id) {
		return taskrepo.findById(id).get();
	}
	
	public Task saveTask(Task task) {
		return taskrepo.save(task);
	}
	
	public void updateTask(Long id, Task task) {
		Task savedTask = taskrepo.findById(id).get();
		savedTask.setTitle(task.getTitle());
		savedTask.setStatus(task.getStatus());
		taskrepo.save(savedTask);
	}
	
	public void deleteTask(Long id) {
		taskrepo.deleteById(id);
	}
}
