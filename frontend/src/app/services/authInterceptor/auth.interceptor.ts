import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthService} from '../authService/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const idToken = localStorage.getItem(AuthService.TOKEN_ID);

    if (idToken) {
      const cloned = req.clone({
        headers: req.headers.set('Authorization',
          'Bearer ' + idToken)
      });

      return next.handle(cloned);
    }
    else {
      return next.handle(req);
    }
  }
}
