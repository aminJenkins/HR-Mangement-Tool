import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AddAppointment } from 'src/app/shared/Appointment';

@Component({
  selector: 'app-add-appointment-form',
  templateUrl: './add-appointment-form.component.html',
  styleUrls: ['./add-appointment-form.component.css'],
})
export class AddAppointmentFormComponent {
  appointment: AddAppointment;
  priorityOptions = ['LOW', 'MIDDLE', 'HIGH'];

  constructor(
    public addAppointmentDialogRef: MatDialogRef<AddAppointmentFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.appointment = {
      titel: '',
      beschreibung: '',
      priority: '',
      beginn: '',
      ende: '',
    };
  }
}
