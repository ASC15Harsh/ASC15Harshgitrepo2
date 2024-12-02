import { Component,inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-review',
  standalone: true,
  imports: [],
  templateUrl: './review.component.html',
  styleUrl: './review.component.css'
})
export class ReviewComponent {
  router = inject(Router);
  back(){
    this.router.navigateByUrl('navbar');
  }
}
