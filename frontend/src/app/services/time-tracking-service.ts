//HTTP Request to backend to get TimeTracking data
import {TimeTracker} from "../shared/TimeTracker";
import {Injectable} from "@angular/core";
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TimeTrackingService {
  private static http: HttpClient;

  constructor(private  http: HttpClient) { }

  public getDatasource(): Observable<TimeTracker[]> {
    let auth_token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQG1hIiwiZXhwIjoxNjcyMTk1MDY4LCJpYXQiOjE2NzIxMDg2NjgsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19.-D7nOsu2_HcGV_x90h7BqAIJCdz86VBSGHb04UaKBEE';
    const headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    });
    return this.http.get<TimeTracker[]>(environment.TIME_TRACKING_URL,{ headers:new HttpHeaders().append('Authorization', `Bearer ${auth_token}`)});
    //return this.http.get<TimeTracker[]>(environment.GREETING_URL,{ headers:new HttpHeaders().append('Authorization', `Bearer ${auth_token}`)});
  }

  public sendTimeTrack(){

  }
}
