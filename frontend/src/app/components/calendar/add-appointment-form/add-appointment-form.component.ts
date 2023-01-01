import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AddAppointment } from 'src/app/shared/Appointment';

@Component({
  selector: 'app-add-appointment-form',
  templateUrl: './add-appointment-form.component.html',
  styleUrls: ['./add-appointment-form.component.css'],
})
export class AddAppointmentFormComponent {
  appointment!: AddAppointment;
  priorityOptions = ['LOW', 'MIDDLE', 'HIGH'];
  addAppointmentFormGroup!: FormGroup;

  constructor(
    public addAppointmentDialogRef: MatDialogRef<AddAppointmentFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fb: FormBuilder
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
      projektId: [''],
      teilnehmer: [[]],
    });
  }

  createAppointment(): void {
    console.log(this.addAppointmentFormGroup.value);
    if (this.addAppointmentFormGroup.valid) {
      this.appointment = this.addAppointmentFormGroup.value;
      console.log(this.appointment);
    }
  }
}
