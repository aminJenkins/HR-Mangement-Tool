import { Token } from './../../models/Token';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationResponse } from '../../shared/AuthenticationResponse';
import jwt_decode from 'jwt-decode';
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  public static TOKEN_ID = 'token';

  constructor(private router: Router, private http: HttpClient) {}

  logOut(): void {
    this.clearLocalStorage();
    this.router.navigateByUrl('/login');
  }

  logIn(email: string, password: string): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(
      'http://localhost:8090/api/login',
      { email, password }
    );

  }

  isUserLoggedIn(): boolean {
    return localStorage.getItem(AuthService.TOKEN_ID) != null;
    // todo check if token is expired
  }

  public setSession(token: string | undefined): void {
    if (token) {
      localStorage.setItem(AuthService.TOKEN_ID, token);
    }
  }

  private clearLocalStorage(): void {
    localStorage.removeItem(AuthService.TOKEN_ID);
  }

  getDecodedAccessToken(): Token | null {
    const token = localStorage.getItem(AuthService.TOKEN_ID) || '{}';
    try {
      return jwt_decode(token);
    } catch (Error) {
      return null;
    }
  }
}
