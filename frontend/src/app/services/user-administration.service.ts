import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {EmployeeExist} from "../shared/employee/EmployeeExist";
import {Department} from "../shared/Department";

@Injectable({
  providedIn: 'root'
})
export class userAdministrationService {
  private static http: HttpClient;

  constructor(private http: HttpClient) {}

  public getDatasource(): Observable<EmployeeExist[]> {
    return this.http.get<EmployeeExist[]>(environment.GET_ALL_EMPLOYEE_URL);
  }

  public createEmployee(employee : any): Observable<any>{
    return this.http.post<any>(environment.CREATE_EMPLOYEE_URL,employee);

  }

  public getDepartments(): Observable<Department[]>{
    return this.http.get<Department[]>(environment.DEPARTMENT);
  }

  public deleteEmployee(employee : number): void{
    this.http.delete<any>(environment.EMPLOYEE_URL+employee).subscribe(() => 'Deleted successful');
  }
}
