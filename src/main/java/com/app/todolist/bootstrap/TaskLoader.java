package com.app.todolist.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.todolist.model.Task;
import com.app.todolist.model.TodoStatus;
import com.app.todolist.repo.TaskRepo;

@Component
public class TaskLoader implements CommandLineRunner{

	private final TaskRepo taskrepo;
	
	public TaskLoader(TaskRepo taskrepo) {
		this.taskrepo = taskrepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		loadTasks();
		
	}

	private void loadTasks() {
		if(taskrepo.count()==0) {
			taskrepo.save(
					Task.builder()
						.title("Buy groceries")
						.status(TodoStatus.NOT_COMPLETED)
						.build()
					);
			taskrepo.save(
					Task.builder()
						.title("Finish project")
						.status(TodoStatus.NOT_COMPLETED)
						.build()
					);
		}
		
	}
}
