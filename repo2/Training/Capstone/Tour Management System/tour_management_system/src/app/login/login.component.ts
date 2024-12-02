import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  userobj: any = {
    email: '',
    password: '',
  };
  errorMessage: string = '';
  attempts: number = 0;
  maxAttempts: number = 3;
  lockoutTime: number = 2 * 60 * 1000;//change for 30 minutes. Now it is for 2 minutes
  lockoutTimestamp: number | null = null;
  isLockedOut: boolean = false;
  remainingTime: number = 0;
  router = inject(Router);

  onlogin() {
    if (this.isLockedOut) {
      this.errorMessage = 'Your account is locked. Please try again later.';
      return;
    }

    if (this.userobj.email === 'admin@gmail.com' && this.userobj.password === 'Admin@123') {
      alert('Login Successful');
      this.router.navigateByUrl('navbar');
      localStorage.setItem('loginuser', this.userobj.email);
      this.resetAttempts();
    } else {
      this.attempts++;
      this.errorMessage = 'Invalid username or password';

      if (this.attempts >= this.maxAttempts) {
        this.lockoutTimestamp = Date.now();
        this.isLockedOut = true;
        this.errorMessage = 'Too many invalid attempts. Your account is locked for 30 minutes.';
        this.startLockoutTimer();
      } else {
        this.router.navigateByUrl('login');
      }
    }
  }

  startLockoutTimer() {
    const interval = setInterval(() => {
      if (this.lockoutTimestamp) {
        const timeElapsed = Date.now() - this.lockoutTimestamp;
        this.remainingTime = Math.max(0, Math.floor((this.lockoutTime - timeElapsed) / 1000));
        
        if (timeElapsed >= this.lockoutTime) {
          this.resetAttempts();
          clearInterval(interval);
        }
      }
    }, 1000);
  }

  resetAttempts() {
    this.attempts = 0;
    this.isLockedOut = false;
    this.lockoutTimestamp = null;
    this.remainingTime = 0;
  }

  get maxAttemptsReached(): boolean {
    return this.attempts >= this.maxAttempts;
  }
}
