import { AppointmentService } from './../../../services/appointmentService/appointment.service';
import { AddAppointment } from './../../../shared/Appointment';
import { Component } from '@angular/core';
import { AppointmentDetailsViewComponent } from '../appointment-details-view/appointment-details-view.component';

import { MatDialog } from '@angular/material/dialog';
import { AddAppointmentFormComponent } from '../add-appointment-form/add-appointment-form.component';
import { Project } from 'src/app/models/Project';

const calendarData = {
  week: '19.12.22 - 23.12.22',
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
      tuesday: null,
      wednesday: null,
      thursday: null,
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
      tuesday: null,
      wednesday: null,
      thursday: null,
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
  displayedColumns: string[] = [
    'Montag',
    'Dienstag',
    'Mittwoch',
    'Donnerstag',
    'Freitag',
  ];

  projects: Project[];

  constructor(
    public dialog: MatDialog,
    private appointmentService: AppointmentService
  ) {
    this.projects = [];
  }

  ngOnInit(): void {
    this.appointmentService.getProjects().subscribe((response: Project[]) => {
      console.log(response);
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
        height: '400px',
        width: '400px',
      }
    );

    addAppointmentDialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed');
      console.log(result);
    });
  }
}
