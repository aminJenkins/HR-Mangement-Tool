import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AppointmentService } from 'src/app/services/appointmentService/appointment.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-delete-appointment-view',
  templateUrl: './delete-appointment-view.component.html',
  styleUrls: ['./delete-appointment-view.component.css'],
})
export class DeleteAppointmentViewComponent {
  constructor(
    public deleteDialogRef: MatDialogRef<DeleteAppointmentViewComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private appointmentService: AppointmentService,
    private snackbar: MatSnackBar
  ) {}

  cancelDeletion(): void {
    this.deleteDialogRef.close('Close!');
  }

  deleteAppointment(id: number): void {
    this.appointmentService.deleteAppointment(id).subscribe((response: any) => {
      this.deleteDialogRef.close('Close!');
      this.showInfoAppointmentSuccessfulDeleted();
      setTimeout(function () {
        window.location.reload();
      }, 2000);
    });
  }

  private showInfoAppointmentSuccessfulDeleted(): void {
    this.snackbar.open('Termin erfolgreich gelöscht', 'OK', {
      duration: 3000,
    });
  }
}
