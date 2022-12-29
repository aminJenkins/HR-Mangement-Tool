import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeViewComponent} from './components/home-view/home-view.component';
import {CalendarViewComponent} from './components/calendar-view/calendar-view.component';
import {TimeTrackingViewComponent} from './components/time-tracking-view/time-tracking-view.component';
import {TimetrackingFormViewComponent} from './components/timetracking-from-view/timetracking-form-view.component';
import {LoginComponent} from './components/login/login.component';
import {AuthGuard} from './services/authGuard/auth-guard.service';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'timetracking', component: TimeTrackingViewComponent, canActivate: [AuthGuard]},
  {path: 'timetracking/timetracking-form', component: TimetrackingFormViewComponent, canActivate: [AuthGuard]},
  {path: '', component: HomeViewComponent, canActivate: [AuthGuard]},
  {path: 'calendar', component: CalendarViewComponent, canActivate: [AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
