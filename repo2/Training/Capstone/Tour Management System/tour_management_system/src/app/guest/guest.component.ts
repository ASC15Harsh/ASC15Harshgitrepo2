import { Component,inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-guest',
  standalone: true,
  imports: [],
  templateUrl: './guest.component.html',
  styleUrl: './guest.component.css'
})
export class GuestComponent {
  router = inject(Router);
  back(){
    this.router.navigateByUrl('navbar');
  }
}
