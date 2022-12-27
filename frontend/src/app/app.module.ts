import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CalendarViewComponent } from './components/calendar-view/calendar-view.component';
import { HomeViewComponent } from './components/home-view/home-view.component';
import {TimeTrackingViewComponent} from  './components/time-tracking-view/time-tracking-view.component';
import { MaterialModule } from './material/material.module';
import {TimeTrackingService} from "./services/time-tracking-service";
import { HttpClientModule } from '@angular/common/http';

// @ts-ignore
@NgModule({
  declarations: [AppComponent, CalendarViewComponent, HomeViewComponent, TimeTrackingViewComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
  ],
  providers: [TimeTrackingService],
  bootstrap: [AppComponent],
})
export class AppModule {}
