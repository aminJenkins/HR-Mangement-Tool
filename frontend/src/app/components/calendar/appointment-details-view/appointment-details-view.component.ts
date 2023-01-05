import {
  UpdateAppointment,
  CalendarTable,
  Appointment,
} from './../../../shared/Appointment';
import { AuthService } from 'src/app/services/authService/auth.service';
import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppointmentService } from 'src/app/services/appointmentService/appointment.service';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-appointment-details-view',
  templateUrl: './appointment-details-view.component.html',
  styleUrls: ['./appointment-details-view.component.css'],
})
export class AppointmentDetailsViewComponent {
  loggedInUser: string | undefined =
    this.authService.getDecodedAccessToken()?.sub;
  updateAppointmentFormGroup!: FormGroup;
  updateAppointment!: UpdateAppointment;

  constructor(
    public dialogRef: MatDialogRef<AppointmentDetailsViewComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private authService: AuthService,
    private appointmentService: AppointmentService,
    private fb: FormBuilder,
    private snackbar: MatSnackBar
  ) {
    this.initForms();
  }

  initForms(): void {
    this.updateAppointmentFormGroup = this.fb.group({
      titel: [this.data.appointment.titel, Validators.required],
      beschreibung: [this.data.appointment.beschreibung, Validators.required],
      beginn: [this.data.appointment.beginn, Validators.required],
      ende: [this.data.appointment.ende, Validators.required],
      datum: [this.data.appointment.datum, Validators.required],
      priority: [this.data.appointment.priority, Validators.required],
      projekt: [this.data.appointment.projekt],
      teilnehmer: [this.data.appointment.teilnehmer],
    });
  }

  isLoggedInUserOwnerOfAppointment(appointmentOwner: string): boolean {
    return this.loggedInUser === appointmentOwner;
  }

  updatingAppointment(): void {
    if (this.updateAppointmentFormGroup.valid) {
      this.updateAppointment = this.updateAppointmentFormGroup.value;
      this.updateAppointment.id = this.data.appointment.id;
      this.showInfoAppointmentSuccessfulUpdated();
      this.appointmentService
        .updateAppointment(this.updateAppointment)
        .subscribe((response: Appointment) => {
          this.dialogRef.close('Close!');
          setTimeout(function () {
            window.location.reload();
          }, 2000);
        });
    }
  }
  private showInfoAppointmentSuccessfulUpdated(): void {
    this.snackbar.open('Termin erfolgreich aktualisiert', 'OK', {
      duration: 3000,
    });
  }
}
