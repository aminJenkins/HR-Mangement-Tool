import {TimetrackExist} from "./TimetrackExist";

export class Workday{
  timeTracks : TimetrackExist[];
  day : string;
  month : string;
  year : string;
  dayMonthNumbers : string;
  date:Date;


  constructor(timeTracks: TimetrackExist[], day: string, month: string, year: string, dayMonthNumbers: string,date:Date) {
    this.timeTracks = timeTracks;
    this.day = day;
    this.month = month;
    this.year = year;
    this.dayMonthNumbers = dayMonthNumbers;
    this.date=date;
  }
}
