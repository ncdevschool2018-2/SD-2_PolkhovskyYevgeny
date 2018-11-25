import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {TimetableExample} from "../model/timetableExample";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {TimetableService} from "../service/timetable.service";
import {Timetable} from "../model/timetable";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Slots} from "../model/slots";
import {SlotService} from "../service/slot.service";
import {DaysOfWeek} from "../model/daysOfWeek";
import {DaysOfWeekService} from "../service/days-of-week.service";
import {TeacherService} from "../service/teacher.service";
import {Subjects} from "../model/subjects";
import {SubjectService} from "../service/subject.service";
import {SubjectTeacherService} from "../service/subject-teacher.service";
import {SubjectTeacher} from "../model/subjectTeacher";
import { FormControl, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-table-teacher',
  templateUrl: './table-teacher.component.html',
  styleUrls: ['./table-teacher.component.css']
})
export class TableTeacherComponent implements OnInit {
  @Input()
  public day: string;
  @Input()
  public teacherNumber: number;
  public groups: Group[];
  public slots: Slots[];
  public slotsDist: Slots[];
  public subjects: Subjects[];
  public subjectsTeacher: SubjectTeacher[];
  public daysOfWeek: DaysOfWeek[];
  private subscriptions: Subscription[] = [];
  public timetable: TimetableExample[];
  public timetable1: Timetable[];
  public editableTimetable: Timetable = new Timetable();
  public editableTimetableExample: TimetableExample = new TimetableExample();
  public chooseTeacher: number = this.teacherNumber;
  public chooseSubject: number;
  public modalRef: BsModalRef;

  stateCtrl = new FormControl();

  myForm = new FormGroup({
    state: this.stateCtrl
  });

  states = [
    'Alabama',
    'Alaska',
    'Arizona',
    'Arkansas',
    'California',
    'Colorado',
    'Connecticut',
    'Delaware',
    'Florida',
    'Georgia',
    'Hawaii',
    'Idaho',
    'Illinois',
    'Indiana',
    'Iowa',
    'Kansas',
    'Kentucky',
    'Louisiana',
    'Maine',
    'Maryland',
    'Massachusetts',
    'Michigan',
    'Minnesota',
    'Mississippi',
    'Missouri',
    'Montana',
    'Nebraska',
    'Nevada',
    'New Hampshire',
    'New Jersey',
    'New Mexico',
    'New York',
    'North Dakota',
    'North Carolina',
    'Ohio',
    'Oklahoma',
    'Oregon',
    'Pennsylvania',
    'Rhode Island',
    'South Carolina',
    'South Dakota',
    'Tennessee',
    'Texas',
    'Utah',
    'Vermont',
    'Virginia',
    'Washington',
    'West Virginia',
    'Wisconsin',
    'Wyoming'
  ];


  constructor(private loadingService: Ng4LoadingSpinnerService,
              private route: ActivatedRoute,
              private timetableService: TimetableService,
              private groupService: GroupService,
              private teacherService: TeacherService,
              private subjectService: SubjectService,
              private slotService: SlotService,
              private daysOfWeekService: DaysOfWeekService,
              private modalService: BsModalService,
              private timeTableService: TimetableService,
              private subjectTeacherService: SubjectTeacherService) {
  }

  ngOnInit() {
    this.chooseTeacher = this.teacherNumber;
    this.loadTimetableNamed();
    /*this.getEmptySlots();*/

  }

  /*private loadTimetableNamed(): void {
    this.loadingService.show();


    this.route.params.subscribe(params => {
      let id: number = +params['id'];
      this.subscriptions.push(this.timetableService.getTimetableNamedByTeacherId(id).subscribe(timetable => {
        // Parse json response into local array
        this.timetable = timetable as TimetableExample[];
        // Check data in console
        this.loadingService.hide();
        this.chooseTeacher = id;
      }));
    });

  }*/
  private loadTimetableNamed(): void {


    this.subscriptions.push(this.timetableService.getTimetableNamedByTeacherId(this.teacherNumber).subscribe(timetable => {
      // Parse json response into local array
      this.timetable = timetable as TimetableExample[];
      // Check data in console


    }));


  }

  public _deleteTimetable(timetableId: string): void {


    this.subscriptions.push(this.timetableService.deleteTimetable(timetableId).subscribe(() => {
      this._updateTimetableExample();
    }));

  }

  public _updateTimetableExample(): void {
    this.loadTimetableNamed();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModalTimetable(template: TemplateRef<any>): void {
    this.loadSubjectTeacherToGetId();
    this.loadTeacherSubjects(this.chooseTeacher);
    this.loadGroups();
    this.loadSlot();
    this.loadDaysOfWeek();
    this.modalRef = this.modalService.show(template);

  }

  private loadGroups(): void {

    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {

      this.groups = groups as Group[];

    }));
  }

  /*private getEmptySlots(){
    this.subscriptions.push(this.timetableService.getTimetableNamedByTeacherId(this.teacherNumber).subscribe(timetable => {
      // Parse json response into local array
      this.timetable = timetable as TimetableExample[];
      // Check data in console


    }));

    for (let named of this.timetable){
      for (let slot of this.slots){

        if(named.time.includes(slot.startTime+" - "+slot.endTime)){
          break;

        }
        this.slotsDist.push(slot);

      }
    }
  }*/
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

  private loadTeacherSubjects(choose: number): void {


    this.subscriptions.push(this.subjectService.getSubjectsForTeacher(choose).subscribe(subjects => {

      this.subjects = subjects as Subjects[];
    }));
  }

  private loadSubjectTeacherToGetId(): void {
    this.subscriptions.push(this.subjectTeacherService.getAllSubjectTeacher().subscribe(subjectsTeacher => {

      this.subjectsTeacher = subjectsTeacher as SubjectTeacher[];
    }));
  }

  public _addTimeTable(): void {

    for (let subjTeach of this.subjectsTeacher) {
      if (subjTeach.teacherId == this.chooseTeacher && subjTeach.subjectId == this.chooseSubject) {
        this.editableTimetable.subjectId = subjTeach.id;
      }
    }
    for (let days of this.daysOfWeek) {
      if (days.name.includes(this.day)) {
        this.editableTimetable.dayOfWeekId = days.id;
      }
    }
    this.subscriptions.push(this.timeTableService.saveTimetable(this.editableTimetable).subscribe(() => {
      this._updateTimetable();
      this.refreshTimetable();
      this.refreshTimetableExample();
      this._updateTimetableExample();
      this.modalRef.hide();
    }));
  }

  public _updateTimetable(): void {
    this.loadTimetable();
  }

  private loadTimetable(): void {


    this.subscriptions.push(this.timeTableService.getTimetable().subscribe(timetable1 => {

      this.timetable1 = timetable1 as Timetable[];
    }));
  }

  private refreshTimetableExample(): void {
    this.editableTimetableExample = new TimetableExample();
  }

  private refreshTimetable(): void {
    this.editableTimetable = new Timetable();
  }








}
