import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'todolist';
  taskList:string[] = [];
  newTask:string = '';

  addTask(){
    console.log(this.newTask);
    this.taskList.push(this.newTask);
    this.newTask='';
  }
}
