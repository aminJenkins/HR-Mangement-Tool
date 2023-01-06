import { Component, Input, NgModule } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

import { Router } from '@angular/router';

import { MatDatepickerModule } from '@angular/material/datepicker';
import {
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
  MatMomentDateModule,
} from '@angular/material-moment-adapter';
import { Project } from 'src/app/models/Project';
import { TimeTrackingService } from 'src/app/services/time-tracking-service';
import { Contingent } from 'src/app/shared/Contingent';
import { TimeTrack } from 'src/app/shared/TimeTrack';

@Component({
  selector: 'app-timetracking-form-view',
  templateUrl: './timetracking-form-view.component.html',
  styleUrls: ['./timetracking-form-view.component.css'],
})
export class TimetrackingFormViewComponent {
  contingents: Contingent[] = [];
  projects: Project[] = [];
  elements = new FormGroup({
    kommentar: new FormControl('', [Validators.required]),
    dauer: new FormControl('', [Validators.required, Validators.min(0)]),
    date: new FormControl('', [Validators.required]),
    contingent: new FormControl('', [Validators.required]),
    projects: new FormControl('', [Validators.required]),
  });

  constructor(
    private _formBuilder: FormBuilder,
    private timeTrackingService: TimeTrackingService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.timeTrackingService
      .getContingents()
      .subscribe((response: Contingent[]) => {
        this.contingents = response;
      });
    this.timeTrackingService.getProjects().subscribe((response: Project[]) => {
      this.projects = response;
    });
  }

  public onSubmit(): void {
    if (this.elements.valid) {
      let values = this.elements.getRawValue();
      let timeTrack = new TimeTrack(
        this.elements.value.projects,
        this.elements.value.kommentar,
        this.elements.value.contingent,
        this.elements.value.dauer,
        this.elements.value.date
      );
      this.timeTrackingService.sendTimeTrack(timeTrack).subscribe((value) => {
        setTimeout(function () {
          window.location.reload();
        }, 500);
      });
      this.router.navigate(['../timetracking']);
    }
  }

  public back(): void {
    this.router.navigate(['../timetracking']);
  }
}
