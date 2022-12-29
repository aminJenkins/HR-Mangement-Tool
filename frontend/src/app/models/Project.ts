export interface Project{
  id : number;

  leiterID : number;

  auftragsgeber : string;

  bezeichnung : string;

  //private Set<TerminEntity> termine;

  projektbeteiligte: string [] ;
}
