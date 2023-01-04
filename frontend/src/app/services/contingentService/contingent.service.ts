import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Contingent} from '../../shared/Contingent';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContingentService {

  constructor(private http: HttpClient) {
  }

  public getContingents(): Observable<Contingent[]>{
    return this.http.get<Contingent[]>(environment.CONTINGENTS_URL);

  }
}
