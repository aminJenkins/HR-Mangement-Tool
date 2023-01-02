import { Component } from '@angular/core';
import { MatTableModule } from "@angular/material/table";
import {TimeTracker} from "../../shared/TimeTracker";
import {TimeTrackingService} from "../../services/time-tracking-service";
import {TimetrackingFormViewComponent} from "../timetracking-form-view/timetracking-form-view.component";
import {TimetrackExist} from "../../shared/TimetrackExist";
import {Router} from "@angular/router";

@Component({
  selector: 'app-time-tracking-view',
  templateUrl: './time-tracking-view.component.html',
  styleUrls: ['./time-tracking-view.component.css']
})
export class TimeTrackingViewComponent {
  displayedColumns: string[] = ['id', 'kommentar','dauer', 'kontingente','datum'];
  testdaten = 'test';
  public dataSource: TimeTracker[] = [];

  constructor(private timeTrackingService : TimeTrackingService,private router: Router){}

  ngOnInit(): void {
    this.timeTrackingService.getDatasource().subscribe((response: TimeTracker[]) => {
      this.dataSource = response;
      console.log(response);
    });
  }

  editTimeTrack(row:TimetrackExist):void{
    //let timeTrack:TimetrackExist = row;
    console.log(row.projektID);
    //TimeTrackingService.setTimeTrackToUpdate(row);
    //this.router.navigate(['timetracking/update-form']);
  }
}

