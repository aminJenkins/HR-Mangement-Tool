import { FormGroup, ValidationErrors, ValidatorFn } from '@angular/forms';

export class Employee {
  id: number | undefined;
  email: string | undefined;
  name: string | undefined;
  nachname: string | undefined;
  anschrift: string | undefined;
  telnr: string | undefined;
  abteilung: number | undefined;

  constructor(
    id: number | undefined,
    email: string | undefined,
    firstname: string | undefined,
    lastname: string | undefined,
    adress: string | undefined,
    telNumber: string | undefined,
    department: number | undefined
  ) {
    this.id = id;
    this.email = email;
    this.name = firstname;
    this.nachname = lastname;
    this.anschrift = adress;
    this.telnr = telNumber;
    this.abteilung = department;
  }
}

export interface UpdateEmployee {
  firstname: string;
  lastname: string;
  address: string;
  telNumber: string;
}
