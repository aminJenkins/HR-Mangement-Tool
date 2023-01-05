export  class CreateEmployee {
  email: string | undefined;
  name: string | undefined;
  nachname: string | undefined;
  anschrift: string | undefined;
  telnr: string | undefined;
  abteilung: number | undefined;
  password : string;
  authority: string;

  constructor(email: string | undefined, name: string | undefined, nachname: string | undefined, anschrift: string | undefined, telnr: string | undefined, abteilung: number | undefined, password: string, authority: string) {
    this.email = email;
    this.name = name;
    this.nachname = nachname;
    this.anschrift = anschrift;
    this.telnr = telnr;
    this.abteilung = abteilung;
    this.password = password;
    this.authority = authority;
  }
}
