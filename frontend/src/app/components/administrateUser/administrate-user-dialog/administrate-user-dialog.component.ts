import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { MatSnackBar } from '@angular/material/snack-bar';
import { userAdministrationService } from '../../../services/user-administration.service';
import { Department } from '../../../shared/Department';
import { CreateEmployee } from '../../../shared/employee/CreateEmployee';

@Component({
  selector: 'administrate-user-dialog',
  templateUrl: './administrate-user-dialog.component.html',
  styleUrls: ['./administrate-user-dialog.component.css'],
})
export class AdministrateUserDialogComponent {
  newEmployee!: CreateEmployee;
  addUserFormGroup!: FormGroup;

  constructor(
    public userDialogComponentMatDialogRef: MatDialogRef<AdministrateUserDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Department[],
    private fb: FormBuilder,
    private userAdministrationService: userAdministrationService,
    private snackbar: MatSnackBar
  ) {
    this.initForms();
  }

  initForms(): void {
    this.addUserFormGroup = this.fb.group({
      address: ['', Validators.required],
      email: ['', Validators.required],
      surname: ['', Validators.required],
      name: ['', Validators.required],
      telNumber: ['', Validators.required],
      department: ['', Validators.required],
      authority: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  createUser(): void {
    if (this.addUserFormGroup.valid) {
      this.userAdministrationService
        .createEmployee(this.buildEmployee())
        .subscribe((newEmployee) =>
          this.userDialogComponentMatDialogRef.close(newEmployee)
        );
      this.showInfoUserSuccessfullyCreated();
    }
  }

  private buildEmployee(): CreateEmployee {
    let employee: CreateEmployee = new CreateEmployee(
      this.addUserFormGroup.value.email,
      this.addUserFormGroup.value.name,
      this.addUserFormGroup.value.surname,
      this.addUserFormGroup.value.address,
      this.addUserFormGroup.value.telNumber,
      this.addUserFormGroup.value.department,
      this.addUserFormGroup.value.password,
      this.addUserFormGroup.value.authority
    );
    return employee;
  }
  private showInfoUserSuccessfullyCreated(): void {
    this.snackbar.open('User erfolgreich erstellt', 'OK', {
      duration: 3000,
    });
  }
}
