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
  //email: string | undefined;
  // name: string | undefined;
  // nachname: string | undefined;
  // anschrift: string | undefined;
  // telnr: string | undefined;
  // abteilung: number | undefined;
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
    console.log('Init');
    this.displayUpdateForm = false;
    this.loadData();
  }

  public loadData(): void {
    this.userAdministrationService
      .getDatasource()
      .subscribe((response: EmployeeExist[]) => {
        this.dataSource = response;
        console.log('Empoyees: ' + response);
      });
    this.userAdministrationService
      .getDepartments()
      .subscribe((response: Department[]) => {
        this.departments = response;
        response.forEach((obj) => console.log('Departments: ' + obj.name));
      });
  }

  public delete(element: any): void {
    console.log(element.id);
    this.userAdministrationService
      .deleteEmployee(element.id)
      .subscribe((value) => {
        this.dataSource = this.dataSource.filter(
          (employee) => employee.id !== element.id
        );
      });
    this.showInfoUserSuccessfullyDeleted();
    this.loadData();
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
    userDialogComponentMatDialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed');
      console.log(result);
    });
  }
}
