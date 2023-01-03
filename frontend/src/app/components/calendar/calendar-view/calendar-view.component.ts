import { Employee } from './../../../shared/employee/Employee';
import { AppointmentService } from './../../../services/appointmentService/appointment.service';
import { AddAppointment } from './../../../shared/Appointment';
import { Component } from '@angular/core';
import { AppointmentDetailsViewComponent } from '../appointment-details-view/appointment-details-view.component';

import { MatDialog } from '@angular/material/dialog';
import { AddAppointmentFormComponent } from '../add-appointment-form/add-appointment-form.component';
import { Project } from 'src/app/models/Project';
import { endOfWeek, startOfWeek } from 'date-fns';

const calendarData = {
  startOfWeek: '2023-01-02',
  endOfWeek: '2023-01-06',
  appointments: [
    {
      monday: {
        description: 'Interne Besprechung',
        from: '09:30',
        to: '10:00',
        projektid: 3,
      },
      tuesday: {
        description: 'Arzttermin',
        from: '12:30',
        to: '14:00',
        projektid: 3,
      },
      wednesday: {
        description: 'Arzttermin',
        from: '09:30',
        to: '10:00',
        projektid: 3,
      },
      thursday: {
        description: 'Kundengespräch',
        from: '11:00',
        to: '15:00',
        projektid: 3,
      },
      friday: {
        description: 'Präsentation',
        from: '09:30',
        to: '10:00',
        projektid: 3,
      },
    },
    {
      monday: {
        description: 'Kundengespräch',
        from: '09:30',
        to: '10:00',
        projektid: 3,
      },

      friday: {
        description: 'Interne Besprechung',
        from: '11:00',
        to: '12:00',
        projektid: 3,
      },
    },
    {
      monday: {
        description: 'Vorstellungsgespräch',
        from: '14:00',
        to: '16:00',
        projektid: 3,
      },

      friday: {
        description: 'Schulung',
        from: '13:00',
        to: '15:00',
        projektid: 3,
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
  calendarData = calendarData;
  currentStartOfWeek = new Date(calendarData.startOfWeek);
  currentEndOfWeek = new Date(calendarData.endOfWeek);
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
    const startDate = startOfWeek(currentDate, { weekStartsOn: 1 });
    const endDate = endOfWeek(currentDate);

    this.appointmentService
      .getCalendarWeekData(startDate, endDate)
      .subscribe((response: any) => {
        console.log(response);
      });

    /*     var curr = new Date();
    const start = startOfWeek(curr, { weekStartsOn: 1 });
    console.log(start);
    const end = endOfWeek(curr);
    console.log(end); */
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
    console.log(this.currentStartOfWeek);
    console.log(this.currentEndOfWeek);
  }
}
