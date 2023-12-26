// @ts-ignore

import {Component, inject, Injectable} from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, provideHttpClient, withFetch} from "@angular/common/http";
import {Router, RouterOutlet} from "@angular/router";



@Component({
  imports: [CommonModule, FormsModule, ReactiveFormsModule, RouterOutlet],
  selector: 'app-login-panel',
  standalone: true,
  styleUrl: './login-panel.component.css',
  templateUrl: './login-panel.component.html'
})

export class LoginPanelComponent {

  constructor(private http:HttpClient,private router:Router) {
  }
  userForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
    aboutMe: new FormControl(''),
  });
  handleSubmit() {
    let info = this.userForm.value;
    let newUser = new user(this.userForm.value.username, this.userForm.value.password, this.userForm.value.firstName, this.userForm.value.lastName, this.userForm.value.email, this.userForm.value.aboutMe);
    // let newUser = user(this.userForm.value.username, this.userForm.value.password, this.userForm.value.firstName, this.userForm.value.lastName, this.userForm.value.email, this.userForm.value.aboutMe);
    // let userToSend = new user(this.userForm.value.username, this.userForm.value.password, this.userForm.value.firstName, this.userForm.value.lastName, this.userForm.value.email, this.userForm.value.aboutMe);
    this.http.post('http://localhost:8080/create',newUser).subscribe((resp)=>console.log('Posted',resp));

  }

  Move(linkName: string) {
    if(linkName=='login'){
      this.router.navigate(['login']);
    }
  }
}
class user {

  username:any;
  password:any;
  firstName:any;
  lastName:any;
  email:any;
  aboutMe:any;
  constructor(
    username:any,
    password:any,
    firstName:any,
    lastName:any,
    email:any,
    aboutMe:any) {
    this.username = username,
      this.password = password,
      this.firstName = firstName,
      this.lastName = lastName,
      this.email = email,
      this.aboutMe = aboutMe
  }}
