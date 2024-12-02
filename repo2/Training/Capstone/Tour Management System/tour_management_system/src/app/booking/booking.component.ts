import { Component,inject } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-booking',
  standalone: true,
  imports: [],
  templateUrl: './booking.component.html',
  styleUrl: './booking.component.css'
})
export class BookingComponent {
  router = inject(Router);
  back(){
    this.router.navigateByUrl('navbar');
  }
}
