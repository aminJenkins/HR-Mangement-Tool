//HTTP Request to backend to get TimeTracking data
import {TimeTracker} from "../shared/TimeTracker";
import {Injectable} from "@angular/core";
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TimeTrackingService {
  private static http: HttpClient;

  constructor(private  http: HttpClient) { }

  public getDatasource(): Observable<TimeTracker[]> {
    return this.http.get<TimeTracker[]>(environment.TIME_TRACKING_JSON_URL);
  }
}
