import { DeleteAppointmentViewComponent } from './../delete-appointment-view/delete-appointment-view.component';
import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AppointmentDetailsViewComponent } from '../appointment-details-view/appointment-details-view.component';
@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css'],
})
export class AppointmentComponent {
  @Input() appointment: any;
  @Input() loggedInUser: string | undefined;
  constructor(public dialog: MatDialog) {}

  deleteAppointment(appointment: any): void {
    const deleteDialogRef = this.dialog.open(DeleteAppointmentViewComponent, {
      data: appointment,
      height: '200px',
      width: '350px',
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
}
