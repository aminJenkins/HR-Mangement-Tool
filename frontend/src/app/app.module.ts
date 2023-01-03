import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CalendarViewComponent } from './components/calendar-view/calendar-view.component';
import { HomeViewComponent } from './components/home-view/home-view.component';
import { TimeTrackingViewComponent } from './components/time-tracking-view/time-tracking-view.component';
import { MaterialModule } from './material/material.module';
import { TimeTrackingService } from './services/time-tracking-service';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { TimetrackingFormViewComponent } from './components/timetracking-form-view/timetracking-form-view.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { LoginComponent } from './components/login/login.component';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { AppointmentDetailsViewComponent } from './components/appointment-details-view/appointment-details-view.component';
import { ProfileComponent } from './components/profile/profile.component';
import {AuthInterceptor} from './services/authInterceptor/auth.interceptor';
import {FormsModule} from '@angular/forms';
import { UpdateTimeTrackingFormComponent } from './components/update-time-tracking-form/update-time-tracking-form.component';


// @ts-ignore
@NgModule({
  declarations: [
    CalendarViewComponent,
    HomeViewComponent,
    TimeTrackingViewComponent,
    TimetrackingFormViewComponent,
    LoginComponent,
    AppointmentComponent,
    AppointmentDetailsViewComponent,
    ProfileComponent,
    AppComponent,
    UpdateTimeTrackingFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    MatNativeDateModule,
    MatDatepickerModule,
    FormsModule,
  ],
  providers: [TimeTrackingService, MatDatepickerModule, MatNativeDateModule,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
