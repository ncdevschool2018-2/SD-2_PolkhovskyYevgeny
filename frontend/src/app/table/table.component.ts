import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {Timetable} from "../model/timetable";
import {Subscription} from "rxjs";
import {TimetableService} from "../service/timetable.service";
import {TimetableExample} from "../model/timetableExample";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {Roles} from "../model/role";
import {Group} from "../model/group";
import {Slots} from "../model/slots";
import {SlotService} from "../service/slot.service";
import {DaysOfWeek} from "../model/daysOfWeek";
import {DaysOfWeekService} from "../service/days-of-week.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {RolesService} from "../service/roles.service";
import {GroupService} from "../service/group.service";
import {Subjects} from "../model/subjects";
import {SubjectService} from "../service/subject.service";
import {Teacher} from "../model/teacher";
import {TeacherService} from "../service/teacher.service";
import {SubjectTeacher} from "../model/subjectTeacher";
import {SubjectTeacherService} from "../service/subject-teacher.service";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input()
  public groupNumber:number;
  @Input()
  public day: string;

  private subscriptions: Subscription[] = [];
  public timetable:TimetableExample[];
  public timetable1: Timetable[];
  public slots: Slots[];
  public roles: Roles[];
  public groups: Group[];
  public subjects: SubjectTeacher[];
  public subjectsAll: Subjects[];
  public daysOfWeek: DaysOfWeek[];
  public modalRef: BsModalRef;
  public editableTimetable: Timetable = new Timetable();
  public editableTimetableExample: TimetableExample = new TimetableExample();
  public editableGroup: Group = new Group();
  public  chooseSubject:number;
  public  chooseTeachers:number;
  public  chooseTeachersName:Teacher[];
  public chooseGroup :number =this.groupNumber;
  constructor(private loadingService: Ng4LoadingSpinnerService,
              private route: ActivatedRoute,
              private modalService: BsModalService,
              private rolesService: RolesService,
              private timetableService: TimetableService,
              private slotService:SlotService,
              private daysOfWeekService:DaysOfWeekService,
              private groupService: GroupService,
              private teacherService: TeacherService,
              private subjectService:SubjectService,
              private subjectTeacherService:SubjectTeacherService,
              private timeTableService:TimetableService,
              ) { }

  ngOnInit() {
    this.loadTimetableNamed();
    /*this.loadTimetable()*/
  }
  /*private loadTimetable(): void {


    this.subscriptions.push(this.timeTableService.getTimetable().subscribe(timetable => {

      this.timetable = timetable as Timetable[];
    }));
  }*/


  /*private loadTimetableNamed(): void {
    this.loadingService.show();

    // Get data from BillingAccountService
    this.route.params.subscribe(params => {
      let id: number = +params['id'];
      this.subscriptions.push(this.timetableService.getTimetableNamedByGroupId(id).subscribe(timetable => {
        // Parse json response into local array
        this.timetable = timetable as TimetableExample[];
        // Check data in console
        this.loadingService.hide();
this.chooseGroup=id;
      }));
    });

  }*/

  private loadTimetableNamed(): void {


    this.subscriptions.push(this.timetableService.getTimetableNamedByGroupId(this.groupNumber).subscribe(timetable => {

      this.timetable = timetable as TimetableExample[];
    }));
  }

  public _openModalTimetable(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.loadGroups();
    this.loadSlot();
    this.loadAllSubjects();
    this.loadDaysOfWeek();
    this.loadSubjectTeacher();
    this.modalRef = this.modalService.show(template);

  }
  private refreshGroup(): void {
    this.editableGroup = new Group();
  }
  private refreshTimetableExample(): void {
    this.editableTimetableExample = new TimetableExample();
  }
  private loadSlot(): void {


    this.subscriptions.push(this.slotService.getSlot().subscribe(slots => {

      this.slots = slots as Slots[];
    }));
  }

  private loadDaysOfWeek(): void {


    this.subscriptions.push(this.daysOfWeekService.getDaysOfWeek().subscribe(daysOfWeek => {

      this.daysOfWeek = daysOfWeek as DaysOfWeek[];
    }));
  }
  private loadGroups(): void {

    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {

      this.groups = groups as Group[];

    }));
  }
  private loadAllSubjects(): void {


    this.subscriptions.push(this.subjectService.getSubjectsAll().subscribe(subjectsAll => {

      this.subjectsAll = subjectsAll as Subjects[];
    }));
  }

  public _checkForTeachers(chooseSubject){
    this.loadChooseTeachers(chooseSubject);

  }

  private loadChooseTeachers(choose:number): void {
    //this.chooseId=new Number();
    this.subscriptions.push(this.teacherService.getTeacherName(choose).subscribe(chooseTeachersName => {

      this.chooseTeachersName = chooseTeachersName as Teacher[];
    }));

  }


  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _addTimeTable(): void {

    for (let subj of this.subjects) {
      if(subj.teacherId==this.chooseTeachers){
        this.editableTimetable.subjectId=subj.id;
      }
    }
this.editableTimetable.groupId=this.groupNumber;
    for( let days of this.daysOfWeek){
      if(days.name.includes(this.day)){
        this.editableTimetable.dayOfWeekId=days.id;
      }
    }
    debugger;
    this.subscriptions.push(this.timeTableService.saveTimetable(this.editableTimetable).subscribe(() => {
      this._updateTimetable();
      this.refreshTimetable();
      this.refreshTimetableExample();
      this._updateTimetableExample();
      this.modalRef.hide();
    }));
  }
  private loadSubjectTeacher(): void {


    this.subscriptions.push(this.subjectTeacherService.getAllSubjectTeacher().subscribe(subject => {

      this.subjects = subject as SubjectTeacher[];
    }));
  }
  public _updateTimetable(): void {
    this.loadTimetable();
  }
  public _updateTimetableExample(): void {
    this.loadTimetableNamed();
  }
  private refreshTimetable(): void {
    this.editableTimetable = new Timetable();
  }
  private loadTimetable(): void {


    this.subscriptions.push(this.timeTableService.getTimetable().subscribe(timetable1 => {

      this.timetable1 = timetable1 as Timetable[];
    }));
  }
  public _deleteTimetable(timetableId: string): void {


    this.subscriptions.push(this.timetableService.deleteTimetable(timetableId).subscribe(() => {
      this._updateTimetableExample();
    }));

  }
}
