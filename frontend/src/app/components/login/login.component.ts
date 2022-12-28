import {Component, Input, OnInit} from '@angular/core';
import {AuthService} from '../../services/authService/auth.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  error: string | undefined;

  constructor(private authService: AuthService, private router: Router, private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    if (this.authService.isUserLoggedIn()) {
      this.router.navigateByUrl('/');
    }
  }

  login(): void {
    if (this.loginForm.valid) {

      const val = this.loginForm.value;
      if (val.email && val.password) {

        this.authService.logIn(val.email, val.password)
          .subscribe(
            (authResponse) => {
              console.log('token: ' + authResponse.token);
              this.authService.setSession(authResponse.token);
              this.router.navigateByUrl('/');
            },
            (err) => {
              console.log(err);
              this.error = err;
            }
          );
      }
    }
  }

}
