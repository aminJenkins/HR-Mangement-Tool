import {Injectable} from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  UrlTree
} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthService} from '../authService/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {
  }

  canActivate(
    route: ActivatedRouteSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.authenticate();
  }

  private authenticate(): boolean {
    if (!this.authService.isUserLoggedIn()) {
      this.router.navigateByUrl('/login');
      return false;
    } else {
      return true;
    }
  }
}
