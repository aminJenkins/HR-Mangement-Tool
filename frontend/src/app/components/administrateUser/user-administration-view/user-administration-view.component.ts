import { Component } from '@angular/core';
import { TimetrackExist } from '../../../shared/TimetrackExist';
import { EmployeeExist } from '../../../shared/employee/EmployeeExist';
import { TimeTrackingService } from '../../../services/time-tracking-service';
import { Router } from '@angular/router';
import { userAdministrationService } from '../../../services/user-administration.service';
import { MatDialog } from '@angular/material/dialog';
import { AddAppointmentFormComponent } from '../../calendar/add-appointment-form/add-appointment-form.component';
import { AdministrateUserDialogComponent } from '../administrate-user-dialog/administrate-user-dialog.component';
import { Department } from '../../../shared/Department';
import { Employee } from '../../../shared/employee/Employee';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-user-administration-view',
  templateUrl: './user-administration-view.component.html',
  styleUrls: ['./user-administration-view.component.css'],
})
export class UserAdministrationViewComponent {
  displayedColumns: string[] = [
    'name',
    'nachname',
    'abteilung',
    'email',
    'delete',
  ];
  displayUpdateForm: boolean = false;
  displayCreateForm: boolean = false;
  empoyeeToUpdate: any;
  public dataSource: EmployeeExist[] = [];
  departments: Department[] = [];

  constructor(
    private userAdministrationService: userAdministrationService,
    private router: Router,
    public dialog: MatDialog,
    private snackbar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.displayUpdateForm = false;
    this.loadData();
  }

  public loadData(): void {
    this.userAdministrationService
      .getDatasource()
      .subscribe((response: EmployeeExist[]) => {
        this.dataSource = response;
      });
    this.userAdministrationService
      .getDepartments()
      .subscribe((response: Department[]) => {
        this.departments = response;
      });
  }

  public delete(element: any): void {
    this.userAdministrationService.deleteEmployee(element.id).subscribe(() => {
      this.dataSource = this.dataSource.filter(
        (employee) => employee.id !== element.id
      );
    });
    this.showInfoUserSuccessfullyDeleted();
  }

  private showInfoUserSuccessfullyDeleted(): void {
    this.snackbar.open('User erfolgreich entfernt', 'OK', {
      duration: 3000,
    });
  }

  showAddEmployeeForm(): void {
    const userDialogComponentMatDialogRef = this.dialog.open(
      AdministrateUserDialogComponent,
      {
        data: this.departments,
        height: '520px',
        width: '600px',
      }
    );
    userDialogComponentMatDialogRef.afterClosed().subscribe((employee) => {
      setTimeout(function () {
        window.location.reload();
      }, 500);
    });
  }
}
