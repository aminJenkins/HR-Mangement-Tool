import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Project } from '../../../shared/Project';
import { ProjectService } from '../../../services/projectService/project.service';
import { Contingent } from '../../../shared/Contingent';
import { Employee } from '../../../shared/employee/Employee';
import { throwError } from 'rxjs';
import { ContingentService } from '../../../services/contingentService/contingent.service';

@Component({
  selector: 'app-create-project-view',
  templateUrl: './create-project-view.component.html',
  styleUrls: ['./create-project-view.component.css'],
})
export class CreateProjectViewComponent {
  createProjectFormGroup!: FormGroup;

  project: Project = new Project();
  contingents!: Contingent[];
  allMitarbeiter!: Employee[];

  constructor(
    public dialogRef: MatDialogRef<CreateProjectViewComponent>,
    private fb: FormBuilder,
    private projectService: ProjectService,
    private contingentService: ContingentService
  ) {
    projectService.getAllEmployees().subscribe(
      (result) => {
        this.allMitarbeiter = result;
      },
      (error) => throwError(error)
    );

    contingentService.getContingents().subscribe(
      (result) => {
        this.contingents = result;
      },
      (error) => throwError(error)
    );

    this.initForms();
  }

  closeWithData(createdProject: Project): void {
    this.dialogRef.close(createdProject);
  }

  initForms(): void {
    this.createProjectFormGroup = this.fb.group({
      bezeichnung: ['', Validators.required],
      auftraggeber: ['', Validators.required],
      budget: ['', Validators.required],
      stundensatz: ['', Validators.required],
      projektleiter: [Validators.required],
      kontingente: [Validators.required],
      teilnehmer: [Validators.required],
    });
  }

  createProject() {
    if (this.createProjectFormGroup.valid) {
      const value = this.createProjectFormGroup.value;
      this.project.kontingente = value.kontingente;
      this.project.leiterID = value.projektleiter;
      this.project.projektbeteiligte = value.teilnehmer;
      this.projectService.createProject(this.project).subscribe((result) => {
        this.closeWithData(result);
      });
    }
  }
}
