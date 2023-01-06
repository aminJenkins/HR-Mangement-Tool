import {Component} from '@angular/core';
import {MatTableModule} from "@angular/material/table";
import {TimeTrack} from "../../../shared/TimeTrack";
import {TimeTrackingService} from "../../../services/time-tracking-service";
import {TimetrackingFormViewComponent} from "../timetracking-form-view/timetracking-form-view.component";
import {TimetrackExist} from "../../../shared/TimetrackExist";
import {Router} from "@angular/router";
import {Workday} from "../../../shared/Workday";
import {
  AdministrateUserDialogComponent
} from "../../administrateUser/administrate-user-dialog/administrate-user-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {MatSnackBar} from "@angular/material/snack-bar";
import {UpdateTimetrackDialogComponent} from "../update-timetrack-dialog/update-timetrack-dialog.component";

@Component({
  selector: 'app-time-tracking-view',
  templateUrl: './time-tracking-view.component.html',
  styleUrls: ['./time-tracking-view.component.css']
})
export class TimeTrackingViewComponent {
  displayedColumns: string[] = ['kommentar', 'dauer', 'kontingentID', 'datum'];
  displayUpdateForm: boolean = false;
  displayCreateForm:boolean =true;
  timeTrackToUpdate: any;
  testdaten = 'test';
  public dataSource: Workday[] = [];

  constructor(private timeTrackingService: TimeTrackingService, private router: Router,public dialog: MatDialog, private snackbar: MatSnackBar) {
  }

  ngOnInit(): void {
    console.log("Init");
    this.displayUpdateForm = false;
    this.loadData();
  }

  public loadData(): void {

    this.timeTrackingService.getSortedDataSource().subscribe((response: Workday[]) => {
      this.dataSource = response;
      console.log("Response "+response);
    });
  }
  public callUpdateForm(row:TimetrackExist):void{
    let timeTrack : TimetrackExist = row;
    console.log(timeTrack)
    this.timeTrackToUpdate=timeTrack;
    this.displayUpdateForm=true;
    console.log(this.displayUpdateForm);
  }

  showUpdateTimeTrackForm(): void {
    const userDialogComponentMatDialogRef = this.dialog.open(
      UpdateTimetrackDialogComponent,
      {
        data: this.timeTrackToUpdate,
        height: '520px',
        width: '600px',
      }
    );
    userDialogComponentMatDialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed');
      console.log(result);
    });
  }
}

