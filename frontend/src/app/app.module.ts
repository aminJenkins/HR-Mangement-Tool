import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { CalendarViewComponent } from './components/calendar-view/calendar-view.component';
import { HomeViewComponent } from './components/home-view/home-view.component';
import {TimeTrackingViewComponent} from  './components/time-tracking-view/time-tracking-view.component';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { AppointmentDetailsViewComponent } from './components/appointment-details-view/appointment-details-view.component';

// @ts-ignore
@NgModule({
  declarations: [AppComponent, CalendarViewComponent, HomeViewComponent, TimeTrackingViewComponent, AppointmentComponent,
    AppointmentDetailsViewComponent,],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
