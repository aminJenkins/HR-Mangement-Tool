import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Employee} from '../shared/employee/Employee';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) {
  }

  getProfileInfo(): Observable<Employee> {
    return this.http.get<Employee>('http://localhost:8090/api/employee/');
  }

  updateProfile(updateInfo: Employee): Observable<Employee> {
    return this.http.post<Employee>('http://localhost:8090/api/employee/update', updateInfo);
  }
}
