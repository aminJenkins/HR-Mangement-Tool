import { Component } from '@angular/core';
import {AuthService} from './services/authService/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'HR-Management';

  constructor(private authService: AuthService) {
  }

  loggedIn(): boolean {
    return this.authService.isUserLoggedIn();
  }
}
