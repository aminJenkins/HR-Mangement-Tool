//HTTP Request to backend to get TimeTracking data
import {TimeTracker} from "../shared/TimeTracker";
import {Injectable} from "@angular/core";
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {Contingent} from "../shared/Contingent";
import {AuthenticationResponse} from "../shared/AuthenticationResponse";
import {Project} from "../models/Project";
import {TimetrackExist} from "../shared/TimetrackExist";
import {UpdateTimeTrackForm} from "../shared/UpdateTimeTrackForm";


@Injectable({
  providedIn: 'root'
})
export class TimeTrackingService {
  private static http: HttpClient;
  private auth_token ='eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQG1hIiwiZXhwIjoxNjcyMzI0MjIzLCJpYXQiOjE2NzIyMzc4MjMsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19.W3XCeoP1f5Sf7C_bqL_E4_7VJFq4pzgOPQvoVeKA--s';
  private static updateTimeTrackForm:TimetrackExist;
  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${this.auth_token}`
  });

  constructor(private  http: HttpClient) { }

  public getDatasource(): Observable<TimetrackExist[]> {
    return this.http.get<TimetrackExist[]>(environment.TIME_TRACKING_URL);
  }

  public getContingents(): Observable<Contingent[]>{
    return this.http.get<Contingent[]>(environment.CONTINGENTS_URL,);

  }

  public getProjects(): Observable<Project[]>{
    return this.http.get<Project[]>(environment.PROJECTS_URL);
  }

  public sendTimeTrack(timeTrack: TimeTracker): Observable<string>{
    console.log(timeTrack)
    return this.http.post<string>(environment.TIME_TRACKING_URL,timeTrack);

  }

/*  public static setTimeTrackToUpdate(timeTrack:TimetrackExist):void{
    TimeTrackingService.updateTimeTrackForm=timeTrack;
  }

  public static getTimeTrackToUpdate():TimetrackExist{
    return TimeTrackingService.updateTimeTrackForm;
  }*/
}
