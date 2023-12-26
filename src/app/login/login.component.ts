import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router, RouterLink, RouterModule, RouterOutlet} from "@angular/router";


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink,RouterOutlet,RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {

  constructor(private http:HttpClient,private router: Router){
  }
  DynamicRouter(linkName: string) {
    if(linkName=='create'){
      this.router.navigate(['create'])
    }

  }
  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  handleLogin() {
     const tokenn = this.http.post('http://localhost:8080/auth/generateToken',this.loginForm.value).subscribe((resp:any)=>{
       console.log('Sucess',resp);
       if(resp.token==null){
         alert('Error, login or password is not correct!')
       }else {
         const jwtToken = resp.token;
         sessionStorage.setItem('auth',jwtToken);
         this.router.navigate(['main']);
       }
       const jwtToken = resp.token;
       sessionStorage.setItem('auth',jwtToken);
       // let info = this.http.get('http://localhost:8080/info',{headers:{Authorization:'Bearer'+jwtToken}}).subscribe((resp:any)=>console.log('Good',resp));
       // alert('token equals to '+jwtToken);
     });


  }

  handleTestLoggedIn() {
    const answer = this.http.get('http://localhost:8080/auth/user/userProfile', {
      headers: {
        "Authorization": 'Bearer ' + sessionStorage.getItem('auth')
      }
    }).subscribe((resp: any) => {
      console.log('Success', resp);
      const answer = resp.message;
      alert('Info = ' + answer);
    });
    // let info = this.http.get('http://localhost:8080/info',{headers:{Authorization:'Bearer '+sessionStorage.getItem('auth')}}).subscribe((resp:any)=>{
    //   console.log('Good',resp)
    //   const answer = resp.name;
    //   alert('The user is: '+answer);
    // });
    // alert('Here is the memory'+sessionStorage.getItem('auth'));

    // let header = new HttpHeaders({
    //   'Authorization':''+sessionStorage.getItem('auth'),
    //   'Access-Control-Request-Method': 'GET',  // This is optional and usually handled by the browser
    //   'Access-Control-Request-Headers': 'Content-Type, Authorization'
    // });
    // let options = {headers: header};
    // let info = this.http.get('http://localhost:8080/info',options).subscribe((resp:any)=>{
    //   console.log('Good',resp)
    //   alert('Here is the memory'+sessionStorage.getItem('auth'));
    //   const answer = resp.name;
    //   alert('The user is: '+answer);
    // });
    // fetch('http://localhost:8080/info', {
    //   headers: {"Authorization":''+sessionStorage.getItem('auth')},
    //   method: "GET",
    // });
    }

}
