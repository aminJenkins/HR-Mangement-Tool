//HTTP Request to backend to get TimeTracking data
import {TimeTrack} from "../shared/TimeTrack";
import {Injectable} from "@angular/core";
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {Contingent} from "../shared/Contingent";
import {AuthenticationResponse} from "../shared/AuthenticationResponse";
import {Project} from "../models/Project";
import {TimetrackExist} from "../shared/TimetrackExist";
import {UpdateTimeTrackForm} from "../shared/UpdateTimeTrackForm";
import {Workday} from "../shared/Workday";


@Injectable({
  providedIn: 'root'
})
export class TimeTrackingService {
  private static http: HttpClient;

  constructor(private  http: HttpClient) { }

  public getSortedDataSource(): Observable<Workday[]> {
  return this.http.get<Workday[]>(environment.TIME_TRACKING_URL);
}

  public getContingents(): Observable<Contingent[]>{
    return this.http.get<Contingent[]>(environment.CONTINGENTS_URL,);

  }

  public getProjects(): Observable<Project[]>{
    return this.http.get<Project[]>(environment.PROJECTS_URL);
  }

  public sendTimeTrack(timeTrack: TimeTrack): Observable<string>{
    console.log(timeTrack)
    return this.http.post<string>(environment.TIME_TRACKING_URL,timeTrack);

  }

  public updateTimeTrack(timeTrack: TimetrackExist): Observable<string>{
    return this.http.put<string>(environment.TIME_TRACKING_URL,timeTrack);
  }

  public deleteTimeTrack(timeTrackID: string): void{
    console.log("Path "+environment.TIME_TRACKING_URL+"${timeTrackID}");
    this.http.delete(environment.TIME_TRACKING_URL+timeTrackID).subscribe(() => 'Deleted successful');
  }
/*  public static setTimeTrackToUpdate(timeTrack:TimetrackExist):void{
    TimeTrackingService.updateTimeTrackForm=timeTrack;
  }

  public static getTimeTrackToUpdate():TimetrackExist{
    return TimeTrackingService.updateTimeTrackForm;
  }*/
}
