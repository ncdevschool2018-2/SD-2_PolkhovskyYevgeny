import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {TimetableExample} from "../model/timetableExample";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {TimetableService} from "../service/timetable.service";
import {Timetable} from "../model/timetable";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Roles} from "../model/role";
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Slots} from "../model/slots";
import {SlotService} from "../service/slot.service";
import {DaysOfWeek} from "../model/daysOfWeek";
import {DaysOfWeekService} from "../service/days-of-week.service";
import {TeacherService} from "../service/teacher.service";
import {Subjects} from "../model/subjects";
import {SubjectService} from "../service/subject.service";

@Component({
  selector: 'app-table-teacher',
  templateUrl: './table-teacher.component.html',
  styleUrls: ['./table-teacher.component.css']
})
export class TableTeacherComponent implements OnInit {
  @Input()
  public day: string;
  public groups: Group[];
  public slots: Slots[];
  public subjects:Subjects[];
  public daysOfWeek: DaysOfWeek[];
  private subscriptions: Subscription[] = [];
  public timetable:TimetableExample[];
  public editableTimetable: Timetable = new Timetable();
  public chooseTeacher:number;
  public modalRef: BsModalRef;
  constructor(private loadingService: Ng4LoadingSpinnerService,
              private route: ActivatedRoute,
              private timetableService:TimetableService,
              private groupService: GroupService,
              private teacherService:TeacherService,
              private subjectService:SubjectService,
              private slotService:SlotService,
              private daysOfWeekService:DaysOfWeekService,
              private modalService: BsModalService,) { }

  ngOnInit() {
    this.loadTimetableNamed()
  }
  private loadTimetableNamed(): void {
    this.loadingService.show();

    // Get data from BillingAccountService
    this.route.params.subscribe(params => {
      let id: number = +params['id'];
      this.subscriptions.push(this.timetableService.getTimetableNamedByTeacherId(id).subscribe(timetable => {
        // Parse json response into local array
        this.timetable = timetable as TimetableExample[];
        // Check data in console
        this.loadingService.hide();
        this.chooseTeacher=id;
      }));
    });

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
    this.loadGroups()
    this.loadSlot();
    this.loadDaysOfWeek();
    this.modalRef = this.modalService.show(template);

  }
  private loadGroups(): void {

    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {

      this.groups = groups as Group[];

    }));
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
  private loadTeacherSubjects(choose:number): void {


    this.subscriptions.push(this.subjectService.getTeacherSubjects(this.chooseTeacher).subscribe(subjects => {

      this.subjects = subjects as Subjects[];
    }));
  }
}
