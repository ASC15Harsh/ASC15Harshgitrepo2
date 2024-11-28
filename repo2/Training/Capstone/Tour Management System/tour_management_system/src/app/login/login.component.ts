import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  userobj : any = {
    email: '',
    password: ''
  }
  errorMessage: string = '';
  router = inject(Router);
  onlogin(){
    if(this.userobj.email == "admin@gmail.com" && this.userobj.password == "Admin@123"){
      alert("Login Successful");
      this.router.navigateByUrl('navbar');
      localStorage.setItem('loginuser',this.userobj.email);
    }
      else{
        this.errorMessage = 'Invalid username or password';
        this.router.navigateByUrl('login');
      }
    }
  }

