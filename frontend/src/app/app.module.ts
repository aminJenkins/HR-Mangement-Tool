import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CalendarViewComponent } from './components/calendar/calendar-view/calendar-view.component';
import { HomeViewComponent } from './components/home-view/home-view.component';
import { TimeTrackingViewComponent } from './components/timetrack/time-tracking-view/time-tracking-view.component';
import { MaterialModule } from './material/material.module';
import { TimeTrackingService } from './services/time-tracking-service';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { TimetrackingFormViewComponent } from './components/timetrack/timetracking-form-view/timetracking-form-view.component';
import {DateAdapter, MatNativeDateModule, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { LoginComponent } from './components/login/login.component';
import { AppointmentComponent } from './components/calendar/appointment/appointment.component';
import { AppointmentDetailsViewComponent } from './components/calendar/appointment-details-view/appointment-details-view.component';
import { ProfileComponent } from './components/profile/profile.component';
import {AuthInterceptor} from './services/authInterceptor/auth.interceptor';
import {FormsModule} from '@angular/forms';
import { UpdateTimeTrackingFormComponent } from './components/timetrack/update-time-tracking-form/update-time-tracking-form.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatMomentDateModule, MAT_MOMENT_DATE_FORMATS } from '@angular/material-moment-adapter';
import { MomentUtcDateAdapter } from './material/MomentUtcDateAdapter';

import { AddAppointmentFormComponent } from './components/calendar/add-appointment-form/add-appointment-form.component';
import {
  UserAdministrationViewComponent
} from "./components/administrateUser/user-administration-view/user-administration-view.component";
import { AdministrateUserDialogComponent } from './components/administrateUser/administrate-user-dialog/administrate-user-dialog.component';
import { UpdateTimetrackDialogComponent } from './components/timetrack/update-timetrack-dialog/update-timetrack-dialog.component';

// @ts-ignore
@NgModule({
  declarations: [
    CalendarViewComponent,
    HomeViewComponent,
    TimeTrackingViewComponent,
    UserAdministrationViewComponent,
    TimetrackingFormViewComponent,
    LoginComponent,
    AppointmentComponent,
    AppointmentDetailsViewComponent,
    ProfileComponent,
    AppComponent,
    UpdateTimeTrackingFormComponent,
    AddAppointmentFormComponent,
    AdministrateUserDialogComponent,
    UpdateTimetrackDialogComponent
  ],
  providers: [TimeTrackingService, MatDatepickerModule, MatNativeDateModule,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true,},
    { provide: MAT_DATE_LOCALE, useValue: 'en-GB' },
    { provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS },
    { provide: DateAdapter, useClass: MomentUtcDateAdapter },
  ],
  imports: [
    BrowserModule,
    MatDatepickerModule,
    MatMomentDateModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    MatNativeDateModule,
    MatDatepickerModule,
    FormsModule,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
