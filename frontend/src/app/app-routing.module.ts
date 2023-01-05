import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CalendarViewComponent} from './components/calendar/calendar-view/calendar-view.component';
import {TimeTrackingViewComponent} from './components/time-tracking-view/time-tracking-view.component';
import {TimetrackingFormViewComponent} from './components/timetracking-form-view/timetracking-form-view.component';
import {LoginComponent} from './components/login/login.component';
import {AuthGuard} from './services/authGuard/auth-guard.service';
import {ProfileComponent} from './components/profile/profile.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: CalendarViewComponent, canActivate: [AuthGuard] },
  {
    path: 'timetracking',
    component: TimeTrackingViewComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'timetracking/timetracking-form',
    component: TimetrackingFormViewComponent,
    canActivate: [AuthGuard],
  },

  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
