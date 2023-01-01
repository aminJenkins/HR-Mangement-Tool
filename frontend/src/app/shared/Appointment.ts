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
