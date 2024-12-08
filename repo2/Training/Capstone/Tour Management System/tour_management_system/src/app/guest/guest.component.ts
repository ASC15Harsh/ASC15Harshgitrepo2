import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GuestsService } from '../service/guests-service';
import { guests } from '../models/guests.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-guest',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './guest.component.html',
  styleUrls: ['./guest.component.css']
})
export class GuestComponent implements OnInit {
  router = inject(Router);
  guestsService = inject(GuestsService);
  guests: guests[] = [];
  searchTerm: string = '';
  currentGuest: guests | null = null;
  newGuest: guests = { id: '', name: '', email: '', phone: '', nationality: '' }; 
  ngOnInit(): void {
    this.loadGuests();
  }

  loadGuests(): void {
    this.guestsService.getGuests().subscribe((data) => {
      this.guests = data;
    });
  }

  back(): void {
    this.router.navigateByUrl('navbar');
  }

  deleteGuest(id: string): void {
    this.guestsService.deleteGuest(id).subscribe(() => {
      this.loadGuests(); 
    });
  }

  selectGuestForEdit(guest: guests): void {
    this.currentGuest = guest; 
    this.newGuest = { ...guest }; 
  }

  saveGuest(): void {
    if (this.newGuest.id) {
    
      this.guestsService.updateGuest(this.newGuest).subscribe(() => {
        this.loadGuests(); 
        this.currentGuest = null; 
        this.newGuest = { id: '', name: '', email: '', phone: '', nationality: '' }; 
      });
    } else {
      this.guestsService.addGuest(this.newGuest).subscribe(() => {
        this.loadGuests(); 
        this.newGuest = { id: '', name: '', email: '', phone: '', nationality: '' }; 
      });
    }
  }

  searchGuests(): void {
    if (this.searchTerm) {
      this.guests = this.guests.filter((guest) =>
        guest.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    } else {
      this.loadGuests(); 
    }
  }
}
