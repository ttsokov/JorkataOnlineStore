import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { CartComponent } from './cart/cart.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { HomeComponent } from './home/home.component';
import { AuthenticationGuardService } from './authentication/authentication-guard.service';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'sign-up',
    component: SignUpComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'favourites',
    component: FavouritesComponent,
    canActivate: [AuthenticationGuardService]
  },
  {
    path: 'cart',
    component: CartComponent,
    canActivate: [AuthenticationGuardService]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
