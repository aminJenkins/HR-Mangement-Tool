import {TimetrackExist} from "./TimetrackExist";
import {Project} from "../models/Project";

export class UpdateTimeTrackForm{
  private  timeTrackToUpdate:TimetrackExist;
  private  relatedProject: Project;

  constructor(timeTrackToUpdate: TimetrackExist, relatedProject: Project) {
    this.timeTrackToUpdate = timeTrackToUpdate;
    this.relatedProject = relatedProject;
  }
}
