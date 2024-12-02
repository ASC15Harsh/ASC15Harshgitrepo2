import { CommonModule } from '@angular/common';
import { Component,inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  admin = {
    email: '',
    name: '',
    phoneNumber: '',
    password: ''
  };

  emailTaken = false;
  phoneTaken = false;
  nameError = false;
  passwordError = false;
  emailInvalid = false;
  phoneInvalid = false;

  onSubmit() {
    this.validateEmail();
    this.validatePhone();
    this.validateName();
    this.validatePassword();

    if (!this.emailTaken && !this.phoneTaken && !this.nameError && !this.passwordError && !this.emailInvalid && !this.phoneInvalid) {
      alert("Registration Success");
      console.log('Registration successful:', this.admin);

      this.admin = {
        email: '',
        name: '',
        phoneNumber: '',
        password: ''
      };
      this.emailTaken = false;
      this.phoneTaken = false;
      this.nameError = false;
      this.passwordError = false;
      this.emailInvalid = false;
      this.phoneInvalid = false;
    }
  }

  validateEmail() {
    if (!this.admin.email.includes('@gmail.com')) {
      this.emailInvalid = true;
    } else {
      this.emailInvalid = false;
    }

    if (this.admin.email === 'admin@gmail.com') {
      this.emailTaken = true;
    } else {
      this.emailTaken = false;
    }
  }

  validatePhone() {
    const phonePattern = /^\d{10}$/;
    this.phoneInvalid = !phonePattern.test(this.admin.phoneNumber);


    if (this.admin.phoneNumber === '1234567890') {
      this.phoneTaken = true;
    } else {
      this.phoneTaken = false;
    }
  }

  validateName() {
    const namePattern = /^[A-Za-z ]+$/;
    this.nameError = !namePattern.test(this.admin.name);
  }

  validatePassword() {
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    this.passwordError = !passwordPattern.test(this.admin.password);
  }
  router = inject(Router);
  back(){
    this.router.navigateByUrl('navbar');
  }
}
