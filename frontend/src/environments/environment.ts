// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  TIME_TRACKING_URL: 'http://localhost:8090/api/timetracking/tracks',
  CONTINGENTS_URL: 'http://localhost:8090/api/contingent/',
  GREETING_URL: 'http://localhost:8090/api/greetings',
  PROJECTS_URL: 'http://localhost:8090/api/projects/',
  EMPLOYEE_URL: 'http://localhost:8090/api/employee/',
  CALENDAR_URL: 'http://localhost:8090/api/calendar/',
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
