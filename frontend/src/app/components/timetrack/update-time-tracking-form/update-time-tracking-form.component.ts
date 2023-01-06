import { Component, Input } from '@angular/core';
import { Contingent } from '../../../shared/Contingent';
import { Project } from '../../../models/Project';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { TimeTrackingService } from '../../../services/time-tracking-service';
import { Router } from '@angular/router';
import { TimeTrack } from '../../../shared/TimeTrack';
import { TimetrackExist } from '../../../shared/TimetrackExist';

@Component({
  selector: 'app-update-time-tracking-form',
  templateUrl: './update-time-tracking-form.component.html',
  styleUrls: ['./update-time-tracking-form.component.css'],
})
export class UpdateTimeTrackingFormComponent {
  @Input() timeTrack: any;
  leaveStatus: boolean = false;
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

    this.prefillForm(this.timeTrack);
  }

  public onSubmit(): void {
    if (this.elements.valid) {
      let values = this.elements.getRawValue();
      let timeTrack = this.parseToTimeTrackExist();
      this.timeTrackingService.updateTimeTrack(timeTrack).subscribe((value) => {
        setTimeout(function () {
          window.location.reload();
        }, 2000);
      });
    }
  }

  private prefillForm(timeTrack: TimetrackExist): void {
    this.elements.value.kommentar = this.timeTrack.kommentar;
    this.elements.value.dauer = this.timeTrack.dauer.toString();
    this.elements.value.date = this.timeTrack.datum;
    this.elements.value.projects = this.timeTrack.projektID.toString();
    this.elements.value.contingent = this.timeTrack.kontingentID.toString();
  }

  private parseToTimeTrackExist(): TimetrackExist {
    let timeTrackExist: TimetrackExist = new TimetrackExist(
      this.timeTrack.id,
      this.elements.value.projects,
      this.elements.value.kommentar,
      this.elements.value.contingent,
      this.elements.value.dauer,
      this.elements.value.date
    );
    return timeTrackExist;
  }

  public backToTimeTracksView(): void {
    this.router.navigate(['../timetracking']);
  }

  public delete(): void {
    this.timeTrackingService
      .deleteTimeTrack(this.timeTrack.id)
      .subscribe((value) => {
        setTimeout(function () {
          window.location.reload();
        }, 500);
      });
  }
}
