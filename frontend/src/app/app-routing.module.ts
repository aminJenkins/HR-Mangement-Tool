import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeViewComponent } from './components/home-view/home-view.component';
import { CalendarViewComponent } from './components/calendar-view/calendar-view.component';
import {LoginComponent} from './components/login/login.component';
import {AuthGuard} from './services/authGuard/auth-guard.service';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: HomeViewComponent, canActivate: [AuthGuard] },
  { path: 'calendar', component: CalendarViewComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
