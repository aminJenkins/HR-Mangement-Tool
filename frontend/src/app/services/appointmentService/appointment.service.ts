import { UpdateAppointment } from './../../shared/Appointment';
import { startOfWeek, endOfWeek } from 'date-fns';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from 'src/app/models/Project';
import { Employee } from 'src/app/shared/employee/Employee';
import { Appointment, AddAppointment } from 'src/app/shared/Appointment';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  constructor(private http: HttpClient) {}

  public getAllProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(environment.PROJECTS_URL + 'all');
  }
  public getAllPossibleParticipants(): Observable<Employee[]> {
    return this.http.get<Employee[]>(environment.CALENDAR_URL + 'participants');
  }

  public createNewAppointment(
    addAppointment: AddAppointment
  ): Observable<Appointment> {
    return this.http.post<AddAppointment>(
      environment.CALENDAR_URL + 'termin',
      addAppointment
    );
  }

  deleteAppointment(appointmentId: number): Observable<void> {
    return this.http.delete<void>(
      environment.CALENDAR_URL + 'termin/' + appointmentId
    );
  }

  updateAppointment(
    updateAppointment: UpdateAppointment
  ): Observable<Appointment> {
    return this.http.put<UpdateAppointment>(
      environment.CALENDAR_URL + 'termin',
      updateAppointment
    );
  }

  public getCalendarWeekData(
    startOfWeek: Date,
    endOfWeek: Date
  ): Observable<any> {
    let queryParams = new HttpParams();
    queryParams = queryParams.append('startOfWeek', startOfWeek.toDateString());
    queryParams = queryParams.append('endOfWeek', endOfWeek.toDateString());

    return this.http.get<any>(environment.CALENDAR_URL, {
      params: queryParams,
    });
  }
}
