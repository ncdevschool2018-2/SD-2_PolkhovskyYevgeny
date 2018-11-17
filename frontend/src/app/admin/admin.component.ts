import {Component, OnInit, TemplateRef} from '@angular/core';
import {Group} from "../model/group";
import {Subscription} from "rxjs/internal/Subscription";
import {GroupService} from "../service/group.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {GroupContentService} from "../service/group-content.service";
import {Roles} from "../model/role";
import {RolesService} from "../service/roles.service";
import {UsersService} from "../service/users.service";
import {Users} from "../model/users";
import {FormControl} from "@angular/forms";
import {NewUser} from "../model/newUser";
import {PupilService} from "../service/pupil.service";
import {TeacherService} from "../service/teacher.service";
import {Timetable} from "../model/timetable";
import {SlotService} from "../service/slot.service";
import {Slots} from "../model/slots";
import {Subjects} from "../model/subjects";
import {DaysOfWeek} from "../model/daysOfWeek";
import {SubjectService} from "../service/subject.service";
import {DaysOfWeekService} from "../service/days-of-week.service";
import {TimetableService} from "../service/timetable.service";
import {Teacher} from "../model/teacher";
import {SubjectTeacher} from "../model/subjectTeacher";
import {SubjectTeacherService} from "../service/subject-teacher.service";


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {

  public groups: Group[];
  public users: Users[];
  public slots: Slots[];
  public subjects: SubjectTeacher[];
  public subjectTeacher: SubjectTeacher[];
  public subjectsAll: Subjects[];
  public daysOfWeek: DaysOfWeek[];
  public editableGroup: Group = new Group();
  public timetable: Timetable[];
  public editableNewUser: NewUser = new NewUser();
  public editableSubject: Subjects = new Subjects();
  public editableTimetable: Timetable = new Timetable();
  public editableSubjectTeacher: SubjectTeacher = new SubjectTeacher();
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  public roles: Roles[];
  public  chooseSubject:number;
  public  chooseTeachers:number;
  public  chooseTeachersName:Teacher[];
  public  teachersAll:Teacher[];




  constructor(
    private groupService: GroupService,
    private groupContentService: GroupContentService,
    private modalService: BsModalService,
    private rolesService: RolesService,
    private userService: UsersService,
    private pupilService: PupilService,
    private teacherService: TeacherService,
    private slotService:SlotService,
    private subjectService:SubjectService,
    private subjectTeacherService:SubjectTeacherService,
    private daysOfWeekService:DaysOfWeekService,
    private timeTableService:TimetableService,
  ) {
  }

  ngOnInit() {
    this.editableNewUser.roleId = 1;
    this.loadGroups();
    this.loadUsers();
    this.loadSubjectTeacher();
    this.loadAllSubjects();

  }

  public _openModal(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.modalRef = this.modalService.show(template);
    this.loadGroups();
  }
  public _openModalSubject(template: TemplateRef<any>): void {
    //this.refreshSubject();
    this.modalRef = this.modalService.show(template);
    //this.loadGroups();
  }
  public _openModalSubjectTeacher(template: TemplateRef<any>): void {
    this.loadAllTeachers();
    this.loadAllSubjects();
    this.modalRef = this.modalService.show(template);

  }

  public _closeModal(): void {
    this.modalRef.hide();
  }


  public _addGroup(): void {
    this.subscriptions.push(this.groupService.saveGroup(this.editableGroup).subscribe(() => {
      this._updateGroups();
      this.refreshGroup();
      this.modalRef.hide();
    }));
  }
  public _addSubject(): void {
    this.subscriptions.push(this.subjectService.saveSubject(this.editableSubject).subscribe(() => {
      this.loadAllSubjects();
      this.modalRef.hide();
    }));
  }
  public _addSubjectTeacher(): void {
    this.subscriptions.push(this.subjectTeacherService.saveSubjectTeacher(this.editableSubjectTeacher).subscribe(() => {
      this.loadAllSubjects();
      this.modalRef.hide();
    }));
  }

  private refreshGroup(): void {
    this.editableGroup = new Group();
  }

  public _updateGroups(): void {
    this.loadGroups();
  }


  private loadGroups(): void {

    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {

      this.groups = groups as Group[];

    }));
  }

  public _openModalPupil(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.modalRef = this.modalService.show(template);
    this.subscriptions.push(this.rolesService.getRoles().subscribe(roles => {
      this.roles = roles as Roles[];
    }));

  }

  public _openModalTeacher(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.loadAllSubjects();
    this.modalRef = this.modalService.show(template);
    this.subscriptions.push(this.rolesService.getRoles().subscribe(roles => {
      this.roles = roles as Roles[];
    }));

  }
  public _openModalTimetable(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.loadSlot();
    this.loadDaysOfWeek();
    this.modalRef = this.modalService.show(template);

  }

  public _updateUsers(): void {
    this.loadUsers();
  }


  private loadUsers(): void {


    this.subscriptions.push(this.userService.getUsers().subscribe(users => {

      this.users = users as Users[];
    }));
  }
  private loadSlot(): void {


    this.subscriptions.push(this.slotService.getSlot().subscribe(slots => {

      this.slots = slots as Slots[];
    }));
  }



  private loadSubjectTeacher(): void {


    this.subscriptions.push(this.subjectTeacherService.getAllSubjectTeacher().subscribe(subject => {

      this.subjects = subject as SubjectTeacher[];
    }));
  }
  private loadAllSubjects(): void {


    this.subscriptions.push(this.subjectService.getSubjectsAll().subscribe(subjectsAll => {

      this.subjectsAll = subjectsAll as Subjects[];
    }));
  }
  private loadDaysOfWeek(): void {


    this.subscriptions.push(this.daysOfWeekService.getDaysOfWeek().subscribe(daysOfWeek => {

      this.daysOfWeek = daysOfWeek as DaysOfWeek[];
    }));
  }
  private loadTimetable(): void {


    this.subscriptions.push(this.timeTableService.getTimetable().subscribe(timetable => {

      this.timetable = timetable as Timetable[];
    }));
  }

  public _addNewPupil(): void {

    this.subscriptions.push(this.pupilService.saveNewPupil(this.editableNewUser).subscribe(() => {
      this._updateUsers();


      this._closeModal();
    }));
  }

  public _addNewTeacher(): void {

    this.subscriptions.push(this.teacherService.saveNewTeacher(this.editableNewUser).subscribe(() => {
      this._updateUsers();


      this._closeModal();
    }));
  }
  public _addTimeTable(): void {

    for (let subj of this.subjects) {
      if(subj.teacherId==this.chooseTeachers){
        this.editableTimetable.subjectId=subj.id;
      }
    }

    this.subscriptions.push(this.timeTableService.saveTimetable(this.editableTimetable).subscribe(() => {
      this._updateTimetable();
      this.refreshTimetable();
      this.modalRef.hide();
    }));
  }
  public _updateTimetable(): void {
    this.loadTimetable();
  }
  private refreshTimetable(): void {
    this.editableTimetable = new Timetable();
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
  private loadAllTeachers(): void {

    this.subscriptions.push(this.teacherService.getTeachers().subscribe(teachersAll => {

      this.teachersAll = teachersAll as Teacher[];
    }));
    this.loadSubjectTeacher();
  }
}
