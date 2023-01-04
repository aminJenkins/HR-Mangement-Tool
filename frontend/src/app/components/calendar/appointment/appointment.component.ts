import { Component, Input } from '@angular/core';
@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css'],
})
export class AppointmentComponent {
  @Input() appointment: any;
  constructor() {}
}
