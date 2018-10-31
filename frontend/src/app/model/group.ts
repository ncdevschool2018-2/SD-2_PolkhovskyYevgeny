import {Timetable} from "./timetable";
import {GroupContent} from "./GroupContent";

export class Group{
   id:number;
   name:string;
   pupilsById:Set<GroupContent>;

   timetablesById:Set<Timetable>;

}
