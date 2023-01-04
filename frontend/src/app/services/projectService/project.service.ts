import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Project} from '../../shared/Project';
import {Employee} from '../../shared/employee/Employee';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http: HttpClient) {
  }

  getAllProjects(): Observable<Project[]> {
    return this.http.get<Project[]>('http://localhost:8090/api/projects/all');
  }

  updateProject(updateInfo: Project): Observable<Project> {
    return this.http.post<Project>('http://localhost:8090/api/projects/update', updateInfo);
  }

  createProject(project: Project): Observable<Project> {
    return this.http.post<Project>('http://localhost:8090/api/projects/', project);
  }

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>('http://localhost:8090/api/employee/all');
  }

}
