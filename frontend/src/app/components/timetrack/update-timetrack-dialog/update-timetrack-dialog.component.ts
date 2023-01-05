import {Component, Inject} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TimeTrackingService} from "../../../services/time-tracking-service";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {MatSnackBar} from "@angular/material/snack-bar";
import {
  AdministrateUserDialogComponent
} from "../../administrateUser/administrate-user-dialog/administrate-user-dialog.component";
import {Department} from "../../../shared/Department";
import {TimetrackExist} from "../../../shared/TimetrackExist";
import {Contingent} from "../../../shared/Contingent";
import {Project} from "../../../models/Project";

@Component({
  selector: 'app-update-timetrack-dialog',
  templateUrl: './update-timetrack-dialog.component.html',
  styleUrls: ['./update-timetrack-dialog.component.css']
})
export class UpdateTimetrackDialogComponent {

  updateTimeTrackFormGroup !: FormGroup;
  contingents !: Contingent [];
  projects!: Project [];

  constructor(public userDialogComponentMatDialogRef: MatDialogRef<AdministrateUserDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: TimetrackExist,
              private fb: FormBuilder,
              private timeTrackingService: TimeTrackingService,
              private snackbar: MatSnackBar) {
    this.initForm();

    this.timeTrackingService.getContingents().subscribe((response: Contingent[]) => {
      this.contingents = response;
      console.log(response);
    });
    this.timeTrackingService.getProjects().subscribe((response: Project[]) => {
      this.projects = response;
      console.log(response);
    });

  }

  initForm():void{
    this.updateTimeTrackFormGroup = new FormGroup({
      kommentar: new FormControl('', [
        Validators.required
      ]),
      dauer: new FormControl('', [
        Validators.required,
        Validators.min(0)
      ]),
      date: new FormControl('', [
        Validators.required,
      ]),
      contingent: new FormControl('', [
        Validators.required,
      ]),
      projects: new FormControl('', [
        Validators.required,
      ]),

    });
  }

  private showInfoUserSuccessfullyUpdated(): void {
    this.snackbar.open('User erfolgreich geandert', 'OK', {
      duration: 3000,
    });
  }

  private showInfoUserSuccessfullyDeleted(): void {
    this.snackbar.open('User erfolgreich entfernt', 'OK', {
      duration: 3000,
    });
  }

  public onSubmit(): void {
    if (this.updateTimeTrackFormGroup.valid) {
      let values = this.updateTimeTrackFormGroup.getRawValue();
      let timeTrack = this.parseToTimeTrackExist();
      console.log(""+timeTrack);
      this.timeTrackingService.updateTimeTrack(timeTrack).subscribe();
      this.userDialogComponentMatDialogRef.close('Close!');
      this.showInfoUserSuccessfullyUpdated();
    }
  }


  private parseToTimeTrackExist():TimetrackExist{
    let timeTrackExist : TimetrackExist = new TimetrackExist(this.data.id,this.updateTimeTrackFormGroup.value.projects,this.updateTimeTrackFormGroup.value.kommentar,
      this.updateTimeTrackFormGroup.value.contingent,this.updateTimeTrackFormGroup.value.dauer,this.updateTimeTrackFormGroup.value.date);
    return timeTrackExist;
  }

  public delete(): void {
    this.timeTrackingService.deleteTimeTrack(this.data.id);
    this.userDialogComponentMatDialogRef.close('Close!');
    this.showInfoUserSuccessfullyDeleted();
  }


}
