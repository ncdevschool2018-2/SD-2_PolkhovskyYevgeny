export class TimetableExample {
  subject:string;
  teacherName:string;
  teacherSurname:string;
  teacherId;number;
time:string;
day:string;
group:string

  static cloneBase(timetableExample:TimetableExample):TimetableExample{
  let clonedTimetableExample: TimetableExample=new TimetableExample();
  clonedTimetableExample.subject=timetableExample.subject;
  clonedTimetableExample.teacherName=timetableExample.teacherName;
  clonedTimetableExample.teacherSurname=timetableExample.teacherSurname;
  clonedTimetableExample.teacherId=timetableExample.teacherId;
  clonedTimetableExample.time=timetableExample.time;
  clonedTimetableExample.day=timetableExample.day;
  clonedTimetableExample.group=timetableExample.group;
  return clonedTimetableExample;
  }
}
