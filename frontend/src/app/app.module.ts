import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CalendarViewComponent} from './components/calendar-view/calendar-view.component';
import {HomeViewComponent} from './components/home-view/home-view.component';
import {TimeTrackingViewComponent} from './components/time-tracking-view/time-tracking-view.component';
import {MaterialModule} from './material/material.module';
import {TimeTrackingService} from './services/time-tracking-service';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {TimetrackingFormViewComponent} from './components/timetracking-from-view/timetracking-form-view.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {LoginComponent} from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import {AuthInterceptor} from './services/authInterceptor/auth.interceptor';
import {FormsModule} from '@angular/forms';


// @ts-ignore
@NgModule({
  declarations: [AppComponent, CalendarViewComponent, HomeViewComponent, TimeTrackingViewComponent, TimetrackingFormViewComponent
    , LoginComponent, ProfileComponent],
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
