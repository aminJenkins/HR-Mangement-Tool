import {Component} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {TimeTrackingService} from "../../services/time-tracking-service";
import { Router } from '@angular/router';
import {TimeTracker} from "../../shared/TimeTracker";
import {Contingent} from "../../shared/Contingent";


@Component({
  selector: 'app-timetracking-from-view',
  templateUrl: './timetracking-form-view.component.html',
  styleUrls: ['./timetracking-form-view.component.css']
})

export class TimetrackingFormViewComponent {
  options: Contingent [] = [];
  elements = new FormGroup({
    gender: new FormControl('', [
      Validators.required
    ]),
    name: new FormControl('', [
      Validators.required,
      Validators.minLength(2)
    ]),
    date: new FormControl('', [
      Validators.required,
    ]),
    status: new FormControl('', [
      Validators.required,
    ]),
  });


  constructor(private _formBuilder: FormBuilder,private timeTrackingService : TimeTrackingService,private router: Router) {}

  ngOnInit(): void {
    this.timeTrackingService.getContingents().subscribe((response:Contingent[]) => {
      this.options = response;
      console.log(response);
    });
  }

  public onSubmit(): void{
    console.log(this.elements.value.gender);
    this.router.navigate(['../timetracking']);
  }
}
