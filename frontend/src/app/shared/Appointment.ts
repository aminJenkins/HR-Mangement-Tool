export interface AddAppointment {
  titel: string;
  beschreibung: string;
  priority: string;
  beginn: string;
  ende: string;
  datum: Date;
  teilnehmer: [];
  projekt: string;
}

export interface Appointment {
  titel: string;
  beschreibung: string;
  priority: string;
  beginn: string;
  ende: string;
  datum: Date;
  teilnehmer: [];
  projekt: string;
}

export interface CalendarTable {
  startOfWeek: string;
  endOfWeek: string;
  appointments: CalendarWeekRow[];
}

export interface CalendarWeekRow {
  monday?: Appointment;
  tuesday?: Appointment;
  wednesday?: Appointment;
  thursday?: Appointment;
  friday?: Appointment;
}
