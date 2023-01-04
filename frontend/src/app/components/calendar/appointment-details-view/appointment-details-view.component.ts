import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-appointment-details-view',
  templateUrl: './appointment-details-view.component.html',
  styleUrls: ['./appointment-details-view.component.css'],
})
export class AppointmentDetailsViewComponent {
  constructor(
    public dialogRef: MatDialogRef<AppointmentDetailsViewComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}
}
