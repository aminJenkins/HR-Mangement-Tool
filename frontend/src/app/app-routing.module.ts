import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeViewComponent } from './components/home-view/home-view.component';
import { CalendarViewComponent } from './components/calendar-view/calendar-view.component';
import {TimeTrackingViewComponent} from "./components/time-tracking-view/time-tracking-view.component";
import {TimetrackingFormViewComponent} from "./components/timetracking-from-view/timetracking-form-view.component";

const routes: Routes = [
  { path: '', component: HomeViewComponent },
  { path: 'calendar', component: CalendarViewComponent },
  { path: 'timetracking', component: TimeTrackingViewComponent },
  { path: 'timetracking/timetracking-form', component: TimetrackingFormViewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
