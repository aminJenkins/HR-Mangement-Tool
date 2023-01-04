import {Component, Input} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProfileService} from '../../services/profileService/profile.service';
import {throwError} from 'rxjs';
import {Employee, UpdateEmployee} from '../../shared/employee/Employee';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {


  employee: Employee;

  profileInfoFormGroup!: FormGroup;
  changePasswordFormGroup!: FormGroup;

  constructor(private profileService: ProfileService, private fb: FormBuilder, private snackbar: MatSnackBar) {
    this.employee = new Employee(0, '', '', '', '', '', 0);
    console.log('emp: ', this.employee);
    profileService.getProfileInfo()
      .subscribe(
        (emp) => {
          this.employee = emp;
        },
        (error => throwError(error))
      );
    this.initForms();
  }

  initForms(): void {
    this.profileInfoFormGroup = this.fb.group({
      email: [''],
      firstname: [''],
      lastname: [''],
      address: [''],
      telNumber: ['', Validators.pattern('[0-9 ]{11}')]
    });

    this.changePasswordFormGroup = this.fb.group({
      newPassword: ['', Validators.required],
      oldPassword: ['', Validators.required],
      confirmPassword: ['', Validators.required],
    });
  }

  updateProfileInfo(): void {
    if (this.profileInfoFormGroup.valid) {

      const value: UpdateEmployee = this.profileInfoFormGroup.value;
      console.log(typeof this.employee);
      const emp = this.fromUpdateEmployee(value);

      this.profileInfoFormGroup.reset();
      this.profileService.updateProfile(emp).subscribe(value1 => {
        this.showInfoUserSuccessfulUpdated();
        console.log('update info: ', value1);
        this.employee = value1;
      });
    }
  }

  changePassword(): void {
    console.log('clicked changePW');
    if (this.changePasswordFormGroup.valid) {
      console.log('pw valid');
      // todo send change password request and wait on response
      this.changePasswordFormGroup.reset();
    } else {
      console.log('pw not valid');
    }
  }

  private showInfoUserSuccessfulUpdated(): void {
    this.snackbar.open('User information successfully updated', 'OK', {duration: 3000});
  }

  private fromUpdateEmployee(updateEmp: UpdateEmployee): Employee {
    return new Employee(
      this.employee.id,
      this.employee.email,
      updateEmp.firstname ? updateEmp.firstname : this.employee.name,
      updateEmp.lastname ? updateEmp.lastname : this.employee.nachname,
      updateEmp.address ? updateEmp.address : this.employee.anschrift,
      updateEmp.telNumber ? updateEmp.telNumber : this.employee.telnr,
      this.employee.abteilung,
    );
  }
}
