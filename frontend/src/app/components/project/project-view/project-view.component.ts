import { Component } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import {throwError} from 'rxjs';
import {Project} from '../../../shared/Project';
import {ProjectService} from '../../../services/projectService/project.service';
import {MatDialog} from '@angular/material/dialog';
import {CreateProjectViewComponent} from '../create-project-view/create-project-view.component';
import {UpdateProjectViewComponent} from '../update-project-view/update-project-view.component';

@Component({
  selector: 'app-project-view',
  templateUrl: './project-view.component.html',
  styleUrls: ['./project-view.component.css']
})
export class ProjectViewComponent {

  allProjects: Project[] = [];
  createdProject: Project | undefined;

  constructor(private projectService: ProjectService, private snackbar: MatSnackBar, public dialog: MatDialog) {

    projectService.getAllProjects().subscribe(
      (projects) => {
        this.allProjects = projects;
        console.log("projekte:", this.allProjects);
      },
      (error) => throwError(error)
    )
  }

  openUpdateProjectDialog(project: Project) {
    const createDialogRef = this.dialog.open(UpdateProjectViewComponent, {data: project});
    createDialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.showProjectSuccessfulUpdated();
      }
    })
  }

  openDeleteProjectDialog(id: number | undefined) {

  }

  openCreateProjectDialog(): void {
    const createDialogRef = this.dialog.open(CreateProjectViewComponent);
    createDialogRef.afterClosed().subscribe( result => {
      if (result) {
        this.allProjects.push(result);
        this.showProjectSuccessfulCreated();
      }
    });
  }

  private showProjectSuccessfulCreated(): void {
    this.snackbar.open('Projekt erfolgreich erstellt', 'OK', {duration: 3000});
  }

  private showProjectSuccessfulUpdated(): void {
    this.snackbar.open('Projekt erfolgreich aktualisiert', 'OK', {duration: 3000});
  }

}
