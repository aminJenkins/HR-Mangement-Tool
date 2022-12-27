


export interface TimeTracker {
  Id : number;
  Beschreibung : string;
  von :string;
  bis:string;
  Kontingent:string;
  dauer : number

  /*constructor(Id: number, Beschreibung: string, von: string, bis: string, Kontingent: string, dauer: number) {
    this.Id = Id;
    this.Beschreibung = Beschreibung;
    this.von = von;
    this.bis = bis;
    this.Kontingent = Kontingent;
    this.dauer = dauer;
  }

  //HTTP Request to backend to get TimeTracking data
  public static getDatasource() : TimeTracker[]{
    let dataSource: TimeTracker[]=[];
    let timetrack = new TimeTracker(0,"Zeiterfassung","01.02.2022","02.02.2022", "Arbeit",3);
    let timetrack1 ={"Id" : 1,
      "Beschreibung" : "Zeiterfassung",
      "von" : "01.02.2022",
      "bis" : "02.02.2022",
      "dauer" : 3,
      "Kontingent": "Arbeit"};
    let timetrack2 ={"Id" : 2,
      "Beschreibung" : "Zeiterfassung",
      "von" : "03.02.2022",
      "bis" : "04.02.2022",
      "dauer" : 12,
      "Kontingent": "Chillen"};
    dataSource.push(timetrack);
    return dataSource;
  }*/


}

