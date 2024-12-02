import { Component,inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hotel',
  standalone: true,
  imports: [],
  templateUrl: './hotel.component.html',
  styleUrl: './hotel.component.css'
})
export class HotelComponent {
  router = inject(Router);
  back(){
    this.router.navigateByUrl('navbar');
  }
}
