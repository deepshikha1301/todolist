import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  taskForm!:FormGroup;
  title = 'todolist';
  taskList:string[] = [];

  constructor(private formBuilder:FormBuilder){}

  ngOnInit(): void{
    this.taskForm = this.formBuilder.group({
      taskName: ['','']
    });
  }

  addTask(){
    this.taskList.push(this.f['taskName'].value); 
    console.log(this.taskList);
  }

  get f(){
    return this.taskForm.controls;
  }
}
