import { Component } from '@angular/core';

@Component({
  selector: 'app-tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.css']
})
export class TasklistComponent {
  title = 'todolist';
  taskList:string[] = [];
  newTask:string = '';

  addTask(){
    console.log(this.newTask);
    this.taskList.push(this.newTask);
    this.newTask='';
  }
}
