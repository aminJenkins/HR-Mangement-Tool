export class TimeTrack {
  projektID : number;
  kommentar : string;
  kontingentID : number;
  dauer : number;
  datum : string;

  constructor(projektID: any, kommentar: any, kontingentID: any, dauer: any, datum: any) {
    this.projektID = projektID;
    this.kommentar = kommentar;
    this.kontingentID = kontingentID;
    this.dauer = dauer;
    this.datum = datum;
  }
}

