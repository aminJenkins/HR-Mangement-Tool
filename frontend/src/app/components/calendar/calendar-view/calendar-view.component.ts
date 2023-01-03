import { Employee } from './../../../shared/employee/Employee';
import { AppointmentService } from './../../../services/appointmentService/appointment.service';
import { AddAppointment, CalendarTable } from './../../../shared/Appointment';
import { Component } from '@angular/core';
import { AppointmentDetailsViewComponent } from '../appointment-details-view/appointment-details-view.component';

import { MatDialog } from '@angular/material/dialog';
import { AddAppointmentFormComponent } from '../add-appointment-form/add-appointment-form.component';
import { Project } from 'src/app/models/Project';
import { endOfWeek, startOfWeek } from 'date-fns';

const calendarData: CalendarTable = {
  startOfWeek: '2023-01-02',
  endOfWeek: '2023-01-06',
  appointments: [
    {
      monday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Interne Besprechung',
        beginn: '09:30',
        ende: '10:00',
        projekt: 'Projekt',
      },
      tuesday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Arzttermin',
        beginn: '12:30',
        ende: '14:00',
        projekt: 'Projekt',
      },
      wednesday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Arzttermin',
        beginn: '09:30',
        ende: '10:00',
        projekt: 'Projekt',
      },
      thursday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Kundengespräch',
        beginn: '11:00',
        ende: '15:00',
        projekt: 'Projekt',
      },
      friday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Präsentation',
        beginn: '09:30',
        ende: '10:00',
        projekt: 'Projekt',
      },
    },
    {
      monday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Kundengespräch',
        beginn: '09:30',
        ende: '10:00',
        projekt: 'Projekt',
      },
      friday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Interne Besprechung',
        beginn: '11:00',
        ende: '12:00',
        projekt: 'Projekt',
      },
    },
    {
      monday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Vorstellungsgespräch',
        beginn: '14:00',
        ende: '16:00',
        projekt: 'Projekt',
      },

      friday: {
        titel: 'Titel',
        datum: new Date(),
        priority: 'HIGH',
        teilnehmer: [],
        beschreibung: 'Schulung',
        beginn: '13:00',
        ende: '15:00',
        projekt: 'Projekt',
      },
    },
  ],
};
@Component({
  selector: 'app-calendar-view',
  templateUrl: './calendar-view.component.html',
  styleUrls: ['./calendar-view.component.css'],
})
export class CalendarViewComponent {
  calendarData!: CalendarTable;
  currentStartOfWeek: string | undefined;
  currentEndOfWeek: string | undefined;

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
        console.log(this.projects);
      });

    this.appointmentService
      .getAllEmployees()
      .subscribe((response: Employee[]) => {
        this.employees = response;
        console.log(this.projects);
      });

    let currentDate = new Date();

    const currentStartDate = startOfWeek(currentDate, { weekStartsOn: 1 });

    const currentEndDate = endOfWeek(currentDate);

    this.appointmentService
      .getCalendarWeekData(currentStartDate, currentEndDate)
      .subscribe((response: CalendarTable) => {
        this.calendarData = calendarData;
        this.currentStartOfWeek = response.startOfWeek;
        this.currentEndOfWeek = response.endOfWeek;
      });
  }

  showAppointmentDetails(appointment: any): void {
    const dialogRef = this.dialog.open(AppointmentDetailsViewComponent, {
      data: appointment,
      height: '400px',
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
    /* console.log(this.currentStartOfWeek);
    console.log(this.currentEndOfWeek); */
  }
}
