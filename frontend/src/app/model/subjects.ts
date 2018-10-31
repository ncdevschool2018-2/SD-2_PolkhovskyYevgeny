import {Teacher} from "./teacher";
import {Timetable} from "./timetable";

export class Subjects{
   id:number;
   subject:string;
   teacherByTeacherId:Teacher;
   teacherId:number;
    timetablesById:Set<Timetable>;
}
