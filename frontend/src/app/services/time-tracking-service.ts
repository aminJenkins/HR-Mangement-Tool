//HTTP Request to backend to get TimeTracking data
import {TimeTracker} from "../shared/TimeTracker";
import {Injectable} from "@angular/core";
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {Contingent} from "../shared/Contingent";
import {AuthenticationResponse} from "../dto/AuthenticationResponse";

@Injectable({
  providedIn: 'root'
})
export class TimeTrackingService {
  private static http: HttpClient;

  constructor(private  http: HttpClient) { }

  public getDatasource(): Observable<TimeTracker[]> {
    let auth_token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQG1hIiwiZXhwIjoxNjcyMzI0MjIzLCJpYXQiOjE2NzIyMzc4MjMsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19.W3XCeoP1f5Sf7C_bqL_E4_7VJFq4pzgOPQvoVeKA--s';
    const headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    });
    // return this.http.get<TimeTracker[]>(environment.TIME_TRACKING_URL,{ headers:new HttpHeaders().append('Authorization', `Bearer ${auth_token}`)});
    // //return this.http.get<TimeTracker[]>(environment.GREETING_URL,{ headers:new HttpHeaders().append('Authorization', `Bearer ${auth_token}`)});
    return this.http.get<TimeTracker[]>('http://localhost:8090/api/timetracking/tracks',{ headers:new HttpHeaders().append('Authorization', `Bearer ${auth_token}`)});
  }

  public getContingents(): Observable<Contingent[]>{
    let auth_token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQG1hIiwiZXhwIjoxNjcyMzI0MjIzLCJpYXQiOjE2NzIyMzc4MjMsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19.W3XCeoP1f5Sf7C_bqL_E4_7VJFq4pzgOPQvoVeKA--s';
    const headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    });
    return this.http.get<Contingent[]>(environment.CONTINGENTS_URL,{ headers:new HttpHeaders().append('Authorization', `Bearer ${auth_token}`)});

  }

  public sendTimeTrack(){

  }
}
