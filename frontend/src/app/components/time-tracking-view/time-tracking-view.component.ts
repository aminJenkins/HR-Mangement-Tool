import {Component} from '@angular/core';
import {MatTableModule} from "@angular/material/table";
import {TimeTrack} from "../../shared/TimeTrack";
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
  displayedColumns: string[] = ['kommentar', 'dauer', 'kontingentID', 'datum'];
  displayUpdateForm: boolean = false;
  timeTrackToUpdate: any;
  testdaten = 'test';
  public dataSource: TimetrackExist[] = [];

  constructor(private timeTrackingService: TimeTrackingService, private router: Router) {
  }

  ngOnInit(): void {
    console.log("Init");
    this.displayUpdateForm = false;
    this.loadData();
  }

  public loadData(): void {
    this.timeTrackingService.getDatasource().subscribe((response: TimetrackExist[]) => {
      this.dataSource = response;
      console.log(response);
    });
  }
}

