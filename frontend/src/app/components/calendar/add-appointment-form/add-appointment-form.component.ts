import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AppointmentService } from 'src/app/services/appointmentService/appointment.service';
import { AddAppointment, Appointment } from 'src/app/shared/Appointment';

@Component({
  selector: 'app-add-appointment-form',
  templateUrl: './add-appointment-form.component.html',
  styleUrls: ['./add-appointment-form.component.css'],
})
export class AddAppointmentFormComponent {
  newAppointment!: AddAppointment;
  priorityOptions = ['LOW', 'MIDDLE', 'HIGH'];
  addAppointmentFormGroup!: FormGroup;

  constructor(
    public addAppointmentDialogRef: MatDialogRef<AddAppointmentFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fb: FormBuilder,
    private appointmentService: AppointmentService
  ) {
    this.initForms();
  }

  initForms(): void {
    this.addAppointmentFormGroup = this.fb.group({
      titel: ['', Validators.required],
      beschreibung: ['', Validators.required],
      beginn: ['', Validators.required],
      ende: ['', Validators.required],
      datum: ['', Validators.required],
      priority: ['', Validators.required],
      projekt: [''],
      teilnehmer: [[]],
    });
  }

  createAppointment(): void {
    if (this.addAppointmentFormGroup.valid) {
      this.newAppointment = this.addAppointmentFormGroup.value;
      this.appointmentService
        .createNewAppointment(this.newAppointment)
        .subscribe((response: Appointment) => {
          console.log(response);
        });
    }
  }
}
