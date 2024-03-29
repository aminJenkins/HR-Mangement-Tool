import { TimeTrack } from '../shared/TimeTrack';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contingent } from '../shared/Contingent';
import { Project } from '../models/Project';
import { TimetrackExist } from '../shared/TimetrackExist';
import { Workday } from '../shared/Workday';

@Injectable({
  providedIn: 'root',
})
export class TimeTrackingService {
  constructor(private http: HttpClient) {}

  public getSortedDataSource(): Observable<Workday[]> {
    return this.http.get<Workday[]>(environment.TIME_TRACKING_URL);
  }

  public getContingents(): Observable<Contingent[]> {
    return this.http.get<Contingent[]>(environment.CONTINGENTS_URL);
  }

  public getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(environment.PROJECTS_URL);
  }

  public sendTimeTrack(timeTrack: TimeTrack): Observable<string> {
    return this.http.post<string>(environment.TIME_TRACKING_URL, timeTrack);
  }

  public updateTimeTrack(timeTrack: TimetrackExist): Observable<string> {
    return this.http.put<string>(environment.TIME_TRACKING_URL, timeTrack);
  }

  public deleteTimeTrack(timeTrackID: string): Observable<any> {
    return this.http.delete(environment.TIME_TRACKING_URL + timeTrackID);
  }
}
