import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})

export class UserRegisterComponent implements OnInit{

  constructor(private formBuilder:FormBuilder, private userService:UserService){}
  registerForm:FormGroup;
  passwordEqual:boolean = true;

  ngOnInit(){
    this.registerForm = this.formBuilder.group({
      emailAddress:['',[Validators.required, Validators.email]],
      passwordEntered:['',[Validators.required, Validators.minLength(8)]],
      passwordConfirm:['',[Validators.required, Validators.minLength(8)]]
    });
  }

  onSubmit(){
    let passwordEntered = this.registerForm.value.passwordEntered;
    let passwordConfirm = this.registerForm.value.passwordConfirm;
    if(passwordConfirm!=passwordEntered){
        this.passwordEqual = false
    }
    let user= new User();
    user.username = this.registerForm.value.emailAddress;
    user.password = passwordEntered;
    this.userService.registerUser(user).subscribe(res=>{
      console.log("****from backend*"+res)
    })
  }
}
