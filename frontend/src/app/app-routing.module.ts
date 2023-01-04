import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeViewComponent} from './components/home-view/home-view.component';
import {CalendarViewComponent} from './components/calendar-view/calendar-view.component';
import {TimeTrackingViewComponent} from './components/time-tracking-view/time-tracking-view.component';
import {TimetrackingFormViewComponent} from './components/timetracking-form-view/timetracking-form-view.component';
import {LoginComponent} from './components/login/login.component';
import {AuthGuard} from './services/authGuard/auth-guard.service';
import {ProfileComponent} from './components/profile/profile.component';
import {ProjectViewComponent} from './components/project-view/project-view.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: HomeViewComponent, canActivate: [AuthGuard]},
  {path: 'timetracking', component: TimeTrackingViewComponent, canActivate: [AuthGuard]},
  {path: 'timetracking/timetracking-form', component: TimetrackingFormViewComponent, canActivate: [AuthGuard]},
  {path: 'calendar', component: CalendarViewComponent, canActivate: [AuthGuard]},
  {path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]},
  {path: 'projects', component: ProjectViewComponent, canActivate: [AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
