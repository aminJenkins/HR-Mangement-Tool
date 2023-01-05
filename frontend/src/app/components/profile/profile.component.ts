import {Component} from '@angular/core';
import {ProfileService} from '../../services/profileService/profile.service';
import {AbstractControl, FormBuilder, FormGroup, FormGroupDirective, Validators} from '@angular/forms';
import {throwError} from 'rxjs';
import {Employee, UpdateEmployee} from '../../shared/employee/Employee';
import {MatSnackBar} from '@angular/material/snack-bar';
import {PasswordReset} from '../../shared/PasswordReset';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {


  employee: Employee;
  errorMessage: string | undefined;
  profileInfoFormGroup!: FormGroup;
  changePasswordFormGroup!: FormGroup;

  constructor(private profileService: ProfileService, private fb: FormBuilder, private snackbar: MatSnackBar) {
    this.employee = new Employee(0, '', '', '', '', '', 0);
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
    }, {validators: this.confirmedValidator('newPassword', 'confirmPassword')});
  }

  updateProfileInfo(): void {
    if (this.profileInfoFormGroup.valid) {

      const value: UpdateEmployee = this.profileInfoFormGroup.value;
      const emp = this.fromUpdateEmployee(value);

      this.profileInfoFormGroup.reset();
      this.profileService.updateProfile(emp).subscribe(value1 => {
        this.showInfoUserUpdated();
        console.log('update info: ', value1);
        this.employee = value1;
      });
    }
  }

  changePassword(formDirective: FormGroupDirective): void {
    console.log('clicked changePW');
    if (this.changePasswordFormGroup.valid) {
      console.log('pw valid');
      const formValue: PasswordReset = this.changePasswordFormGroup.value;
      console.log('password values', formValue);

      this.profileService.resetPassword(formValue).subscribe(() => {
        this.errorMessage = undefined;
        this.changePasswordFormGroup.reset();
        formDirective.resetForm();
        this.changePasswordFormGroup.markAsUntouched();
        this.showInfoPasswordReset();
      }, (error: HttpErrorResponse) => {
        if (error.status === 400) {
          this.errorMessage = 'Password was not confirmed correctly';
        } else if (error.status === 403) {
          this.errorMessage = 'Old password is not correct';
        } else {
          this.errorMessage = error.message;
        }
      });
    } else {
      console.log('pw not valid');
    }
  }

  get isNewPasswordMissing(): boolean {
    if (this.pwForm().newPassword.touched && this.pwForm().newPassword.invalid && this.pwForm().newPassword.errors) {
      return this.pwForm().newPassword.errors?.required;
    }
    return false;
  }

  get isConfirmPasswordMissing(): boolean {
    if (this.hasConfirmPasswordErrors()) {
      return this.pwForm().confirmPassword.errors?.required;
    }
    return false;
  }

  get doesConfirmPasswordMatch(): boolean {
    if (this.hasConfirmPasswordErrors()) {
      return this.pwForm().confirmPassword.errors?.confirmedValidator;
    }
    return false;
  }

  hasConfirmPasswordErrors(): boolean {
    return !!(this.pwForm().confirmPassword.touched && this.pwForm().confirmPassword.invalid && this.pwForm().confirmPassword.errors);
  }

  pwForm(): { [p: string]: AbstractControl<any, any> } {
    return this.changePasswordFormGroup.controls;
  }

  private showInfoUserUpdated(): void {
    this.snackbar.open('Profil wurde erfolgreich aktualisiert', 'OK', {duration: 3000});
  }

  private showInfoPasswordReset(): void {
    this.snackbar.open('Passwort wurde erfolgreich aktualisiert', 'OK', {duration: 5000});
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

  private confirmedValidator(controlName: string, matchingControlName: string): (formGroup: FormGroup) => void {
    return (formGroup: FormGroup) => {
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];
      if (matchingControl.errors && !matchingControl.errors.confirmedValidator) {
        return;
      }
      if (control.value !== matchingControl.value) {
        matchingControl.setErrors({confirmedValidator: true});
      } else {
        matchingControl.setErrors(null);
      }
    };
  }
}
