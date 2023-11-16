import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, provideHttpClient, withFetch} from "@angular/common/http";


@Component({
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  selector: 'app-login-panel',
  standalone: true,
  styleUrl: './login-panel.component.css',
  templateUrl: './login-panel.component.html'
})
export class LoginPanelComponent {

  constructor(private http:HttpClient) {
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
    let userToSend = new user(this.userForm.value.username, this.userForm.value.password, this.userForm.value.firstName, this.userForm.value.lastName, this.userForm.value.email, this.userForm.value.aboutMe);
    this.http.put('http://localhost:8080/create',userToSend);

  }
}
