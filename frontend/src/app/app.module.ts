import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { CalendarViewComponent } from './components/calendar-view/calendar-view.component';
import { HomeViewComponent } from './components/home-view/home-view.component';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { AppointmentDetailsViewComponent } from './components/appointment-details-view/appointment-details-view.component';

@NgModule({
  declarations: [
    AppComponent,
    CalendarViewComponent,
    HomeViewComponent,
    AppointmentComponent,
    AppointmentDetailsViewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
