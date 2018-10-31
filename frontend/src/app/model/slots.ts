import {Timetable} from "./timetable";

export class Slots{
    id:number;
    startTime:string;
    endTime:string;

    timetablesById:Set<Timetable>;
}
