import { Routes } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { FacilityComponent } from './facility/facility.component';
import { GuestComponent } from './guest/guest.component';
import { HotelComponent } from './hotel/hotel.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegistrationComponent } from './registration/registration.component';
import { ReviewComponent } from './review/review.component';
import { authGuard } from './auth.guard';

export const routes: Routes = [
    {path: '' , component : LoginComponent},
    {path: 'booking' , component : BookingComponent},
    {path: 'facility' , component : FacilityComponent},
    {path: 'guest' , component : GuestComponent},
    {path: 'hotel' , component : HotelComponent},
    {path: 'login' , component : LoginComponent},
    {path: 'navbar' , component : NavbarComponent, canActivate:[authGuard]},
    {path: 'registration' , component : RegistrationComponent},
    {path: 'review' , component : ReviewComponent},

];
