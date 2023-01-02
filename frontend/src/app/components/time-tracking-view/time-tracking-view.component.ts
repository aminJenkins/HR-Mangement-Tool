import { Component } from '@angular/core';
import { MatTableModule } from "@angular/material/table";
import {TimeTracker} from "../../shared/TimeTracker";
import {TimeTrackingService} from "../../services/time-tracking-service";
import {TimetrackingFormViewComponent} from "../timetracking-from-view/timetracking-form-view.component";

@Component({
  selector: 'app-time-tracking-view',
  templateUrl: './time-tracking-view.component.html',
  styleUrls: ['./time-tracking-view.component.css']
})
export class TimeTrackingViewComponent {
  displayedColumns: string[] = ['id', 'kommentar','dauer', 'kontingente','datum'];
  testdaten = 'test';
  public dataSource: TimeTracker[] = [];

  constructor(private timeTrackingService : TimeTrackingService){}

  ngOnInit(): void {
    this.timeTrackingService.getDatasource().subscribe((response: TimeTracker[]) => {
      this.dataSource = response;
      console.log(response);
    });
  }
}

