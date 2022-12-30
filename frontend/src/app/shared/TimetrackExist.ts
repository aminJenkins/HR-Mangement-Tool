import {TimeTracker} from "./TimeTracker";

export class TimetrackExist extends TimeTracker{
  id : number;

  constructor(id:number,projektID: any, kommentar: any, kontingentID: any, dauer: any, datum: any) {
    super(projektID, kommentar, kontingentID, dauer, datum);
    this.id = id;
  }

}
