import { FormGroup, ValidationErrors, ValidatorFn } from '@angular/forms';
import { Employee } from './Employee';

export class EmployeeExist extends Employee {
  id: number | undefined;
  constructor(
    id: number | undefined,
    email: string | undefined,
    name: string | undefined,
    nachname: string | undefined,
    anschrift: string | undefined,
    telnr: string | undefined,
    abteilung: number | undefined
  ) {
    super(id, email, name, nachname, anschrift, telnr, abteilung);
    this.id = id;
  }
}

export interface UpdateEmployee {
  firstname: string;
  lastname: string;
  address: string;
  telNumber: string;
}
