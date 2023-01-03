import { Employee } from './../../../shared/employee/Employee';
import { AppointmentService } from './../../../services/appointmentService/appointment.service';
import { AddAppointment, CalendarTable } from './../../../shared/Appointment';
import { Component } from '@angular/core';
import { AppointmentDetailsViewComponent } from '../appointment-details-view/appointment-details-view.component';

import { MatDialog } from '@angular/material/dialog';
import { AddAppointmentFormComponent } from '../add-appointment-form/add-appointment-form.component';
import { Project } from 'src/app/models/Project';
import { addDays, endOfWeek, startOfWeek } from 'date-fns';
import subDays from 'date-fns/subDays';

@Component({
  selector: 'app-calendar-view',
  templateUrl: './calendar-view.component.html',
  styleUrls: ['./calendar-view.component.css'],
})
export class CalendarViewComponent {
  calendarData!: CalendarTable;
  currentStartOfWeek!: Date | number;
  currentEndOfWeek!: Date | number;

  displayedColumns: string[] = [
    'Montag',
    'Dienstag',
    'Mittwoch',
    'Donnerstag',
    'Freitag',
  ];

  projects: Project[];
  employees: Employee[];

  constructor(
    public dialog: MatDialog,
    private appointmentService: AppointmentService
  ) {
    this.projects = [];
    this.employees = [];
  }

  ngOnInit(): void {
    this.appointmentService
      .getAllProjects()
      .subscribe((response: Project[]) => {
        this.projects = response;
      });

    this.appointmentService
      .getAllEmployees()
      .subscribe((response: Employee[]) => {
        this.employees = response;
      });

    let currentDate = new Date();

    const currentStartDate = startOfWeek(currentDate, { weekStartsOn: 1 });

    const currentEndDate = subDays(endOfWeek(currentDate), 1);

    this.appointmentService
      .getCalendarWeekData(currentStartDate, currentEndDate)
      .subscribe((response: CalendarTable) => {
        this.calendarData = response;
        this.currentStartOfWeek = new Date(response.startOfWeek);
        this.currentEndOfWeek = new Date(response.endOfWeek);
      });
  }

  showAppointmentDetails(appointment: any): void {
    const dialogRef = this.dialog.open(AppointmentDetailsViewComponent, {
      data: appointment,
      height: '520px',
      width: '600px',
    });
    dialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed');
      console.log(result);
    });
  }

  showAddAppointmentForm(): void {
    const addAppointmentDialogRef = this.dialog.open(
      AddAppointmentFormComponent,
      {
        data: {
          employees: this.employees,
          projects: this.projects,
        },
        height: '520px',
        width: '600px',
      }
    );

    addAppointmentDialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed');
      console.log(result);
    });
  }

  showAppointmentsNextWeek(): void {
    this.currentStartOfWeek = addDays(this.currentStartOfWeek, 7);
    this.currentEndOfWeek = addDays(this.currentEndOfWeek, 7);
    this.appointmentService
      .getCalendarWeekData(this.currentStartOfWeek, this.currentEndOfWeek)
      .subscribe((response: CalendarTable) => {
        this.calendarData = response;
        this.currentStartOfWeek = new Date(response.startOfWeek);
        this.currentEndOfWeek = new Date(response.endOfWeek);
      });
  }

  showAppointmentsPreviousWeek(): void {
    this.currentStartOfWeek = subDays(this.currentStartOfWeek, 7);
    this.currentEndOfWeek = subDays(this.currentEndOfWeek, 7);
    this.appointmentService
      .getCalendarWeekData(this.currentStartOfWeek, this.currentEndOfWeek)
      .subscribe((response: CalendarTable) => {
        this.calendarData = response;
        this.currentStartOfWeek = new Date(response.startOfWeek);
        this.currentEndOfWeek = new Date(response.endOfWeek);
      });
  }
}
