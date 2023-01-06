import { Component, Inject } from '@angular/core';
import { Project } from '../../../shared/Project';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProjectService } from '../../../services/projectService/project.service';
import { Contingent } from '../../../shared/Contingent';
import { Employee } from '../../../shared/employee/Employee';
import { throwError } from 'rxjs';
import { ContingentService } from '../../../services/contingentService/contingent.service';

@Component({
  selector: 'app-update-project-view',
  templateUrl: './update-project-view.component.html',
  styleUrls: ['./update-project-view.component.css'],
})
export class UpdateProjectViewComponent {
  updateProjectFormGroup!: FormGroup;

  contingents!: Contingent[];
  allMitarbeiter!: Employee[];

  selectedTeilnehmer: string[] = [];
  selectedContingents: number[] = [];
  selectedLeiter: number;

  constructor(
    public dialogRef: MatDialogRef<UpdateProjectViewComponent>,
    @Inject(MAT_DIALOG_DATA) public project: Project,
    private fb: FormBuilder,
    private projectService: ProjectService,
    private contingentService: ContingentService
  ) {
    this.selectedLeiter = project.leiterID!;
    this.selectedTeilnehmer = project.projektbeteiligte!;
    this.selectedContingents = project.kontingente!;

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

  initForms(): void {
    this.updateProjectFormGroup = this.fb.group({
      bezeichnung: ['', Validators.required],
      auftraggeber: ['', Validators.required],
      budget: ['', Validators.required],
      stundensatz: ['', Validators.required],
      projektleiter: [Validators.required],
      kontingente: [Validators.required],
      teilnehmer: [Validators.required],
    });
  }

  updateProject() {
    if (this.updateProjectFormGroup.valid) {
      const value = this.updateProjectFormGroup.value;
      this.project.kontingente = this.selectedContingents;
      this.project.leiterID = this.selectedLeiter;
      this.project.projektbeteiligte = this.selectedTeilnehmer;
      this.projectService.updateProject(this.project).subscribe((result) => {
        this.closeWithData(result);
      });
    }
  }

  closeWithData(createdProject: Project): void {
    this.dialogRef.close(createdProject);
  }
}
