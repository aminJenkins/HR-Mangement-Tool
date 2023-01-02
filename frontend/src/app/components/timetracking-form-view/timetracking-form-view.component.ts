import {Component, Input} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {TimeTrackingService} from "../../services/time-tracking-service";
import { Router } from '@angular/router';
import {TimeTracker} from "../../shared/TimeTracker";
import {Contingent} from "../../shared/Contingent";
import {Project} from "../../models/Project";


@Component({
  selector: 'app-timetracking-form-view',
  templateUrl: './timetracking-form-view.component.html',
  styleUrls: ['./timetracking-form-view.component.css']
})

export class TimetrackingFormViewComponent {
  contingents: Contingent [] = [];
  projects : Project [] = [];
  elements = new FormGroup({
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


  constructor(private _formBuilder: FormBuilder,private timeTrackingService : TimeTrackingService,private router: Router) {}

  ngOnInit(): void {
    this.timeTrackingService.getContingents().subscribe((response:Contingent[]) => {
      this.contingents = response;
      console.log(response);
    });
    this.timeTrackingService.getProjects().subscribe((response:Project[]) => {
      this.projects = response;
      console.log(response);
    });
    //console.log("testdaten:" + this.dataFromComponent)
  }

  public onSubmit(): void{
    if (this.elements.valid) {
    let values = this.elements.getRawValue();
    let timeTrack = new TimeTracker(this.elements.value.projects,this.elements.value.kommentar,this.elements.value.contingent,this.elements.value.dauer,this.elements.value.date);
    this.timeTrackingService.sendTimeTrack(timeTrack).subscribe(value => console.log(" termi antwort:", value));
    console.log(timeTrack);
    //console.log(this.elements.value.kommentar);
    this.router.navigate(['../timetracking']);
  }
  }

}
