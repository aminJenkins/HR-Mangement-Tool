export class Project {
  id: number | undefined;
  stundensatz: number | undefined;
  budget: number | undefined;
  leiterID: number | undefined;
  auftragsgeber: string | undefined;
  bezeichnung: string | undefined;
  projektbeteiligte: string[] | undefined;
  kontingente: number [] | undefined;

  constructor() {
  }
}
