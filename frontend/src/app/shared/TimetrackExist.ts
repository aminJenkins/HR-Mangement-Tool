import {TimeTrack} from "./TimeTrack";

export class TimetrackExist extends TimeTrack{
  id : number;

  constructor(id:number,projektID: any, kommentar: any, kontingentID: any, dauer: any, datum: any) {
    super(projektID, kommentar, kontingentID, dauer, datum);
    this.id = id;
  }

}
