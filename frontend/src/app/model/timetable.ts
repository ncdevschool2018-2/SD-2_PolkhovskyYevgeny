import {Subjects} from "./subjects";
import {Group} from "./group";
import {Slots} from "./slots";
import {DaysOfWeek} from "./daysOfWeek";

export class Timetable{
   id:number;
    subjectsBySubjectId:Subjects;
    slotsBySlotId:Slots;
    daysOfWeekByDayOfWeekId:DaysOfWeek;
   groupId:number;
   subjectId:number;
   slotId:number;
   dayOfWeekId:number;
    universityGroupByGroupId:Group;
}
