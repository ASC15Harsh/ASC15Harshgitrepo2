import { Component,inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-facility',
  standalone: true,
  imports: [],
  templateUrl: './facility.component.html',
  styleUrl: './facility.component.css'
})
export class FacilityComponent {
  router = inject(Router);
  back(){
    this.router.navigateByUrl('navbar');
  }
}
