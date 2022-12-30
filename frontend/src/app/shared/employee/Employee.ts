export class Employee {
  id: number | undefined;
  email: string | undefined;
  name: string | undefined;
  nachname: string | undefined;
  anschrift: string | undefined;
  telnr: string | undefined;
  abteilung: number | undefined;

  constructor(id: number | undefined, email: string | undefined, name: string | undefined,
              nachname: string | undefined, anschrift: string | undefined,
              telnr: string | undefined, abteilung: number | undefined) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.nachname = nachname;
    this.anschrift = anschrift;
    this.telnr = telnr;
    this.abteilung = abteilung;
  }
}


export interface UpdateEmployee {
  firstname: string;
  lastname: string;
  address: string;
  telNumber: string;
}
