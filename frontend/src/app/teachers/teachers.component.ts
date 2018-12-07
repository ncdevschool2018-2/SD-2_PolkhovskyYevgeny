import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {Teacher} from "../model/teacher";
import {Subscription} from "rxjs";
import {TeacherService} from "../service/teacher.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Roles} from "../model/role";
import {Group} from "../model/group";
import {Subjects} from "../model/subjects";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {RolesService} from "../service/roles.service";
import {SubjectService} from "../service/subject.service";
import {NewUser} from "../model/newUser";
import {Users} from "../model/users";
import {UsersService} from "../service/users.service";
import {SubjectTeacher} from "../model/subjectTeacher";
import {SubjectTeacherService} from "../service/subject-teacher.service";
import {PageTeacher} from "../model/pageTeacher";
import {Slots} from "../model/slots";


@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit {
  @Input()
  public slots: Slots[];
  public teacherConfirmId: number;
  public teacherConfirmName: string;
  public teacherConfirmSurname: string;
  public teachers: Teacher[];
  public modalRef: BsModalRef;
  public roles: Roles[];
  private subscriptions: Subscription[] = [];
  public editableGroup: Group = new Group();
  public subjectsAll: Subjects[];
  public subjectsAvailable: Subjects[] = [];
  public editableNewUser: NewUser = new NewUser();
  public users: Users[];
  public busySubjects: number[] = [];
  public teachersAll: Teacher[];
  public subjects: SubjectTeacher[];
  public editableSubjectTeacher: SubjectTeacher = new SubjectTeacher();
  page: PageTeacher;
  currentPage: number = 1;
  tChange: boolean=false;
  public search: string = "";
  public paghide: boolean = false;
  public kj: string = "";
  constructor(private teacherService: TeacherService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private rolesService: RolesService,
              private subjectService: SubjectService,
              private userService: UsersService,
              private subjectTeacherService: SubjectTeacherService,) {
  }

  ngOnInit() {
    this.loadUsers();
    this.loadTeachers(1);

  }


  private loadTeachers(page: number): void {
    this.subscriptions.push(this.teacherService.getPageTeachers(page).subscribe(page => {
      // Parse json response into local array
      this.page = page as PageTeacher;
      this.teachers=this.page.content;
    }));
    /*this.contentArray = this.groups;*/
  }


  pageChanged(event: any): void {
    this.loadTeachers(event.page);
  }
  public k(): void {
    if (this.search.length == 0) {
      this.loadTeachers(1);
      this.paghide=false;

    }
    else {

      this.kj = this.search;
      this.subscriptions.push(this.teacherService.findTeacher(this.kj).subscribe(numb => {
        // Parse json response into local array
        this.teachers = numb as Teacher[];
        this.paghide=true;

      }));
    }
  }

  public _deleteTeacher(teacherId: string): void {
    this.subscriptions.push(this.userService.deleteUsers(teacherId).subscribe(() => {
      this._updateTeachers();
      this._closeModal();
    }));
  }


  public _updateTeachers(): void {
    this.loadTeachers(this.currentPage);
  }


  public _openModalTeacher(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.loadAllSubjects();
    this.modalRef = this.modalService.show(template);
    this.subscriptions.push(this.rolesService.getRoles().subscribe(roles => {
      this.roles = roles as Roles[];
    }));
  }


  private refreshGroup(): void {
    this.editableGroup = new Group();
  }


  private loadAllSubjects(): void {
    this.subscriptions.push(this.subjectService.getSubjectsAll().subscribe(subjectsAll => {
      this.subjectsAll = subjectsAll as Subjects[];
    }));
  }


  public _closeModal(): void {
    this.modalRef.hide();
  }


  public _addNewTeacher(): void {
    this.editableNewUser.roleId = 2;
    this.subscriptions.push(this.teacherService.saveNewTeacher(this.editableNewUser).subscribe(() => {
      this._updateUsers();
      this._updateTeachers();
      this._closeModal();
    }));
  }


  public _updateUsers(): void {
    this.loadUsers();
  }


  private loadUsers(): void {
    this.subscriptions.push(this.userService.getUsers().subscribe(users => {
      this.users = users as Users[];
    }));
  }


  public _openModalSubjectTeacher(template: TemplateRef<any>): void {
    this.busySubjects.splice(0, this.busySubjects.length);
    this.subjectsAvailable.splice(0, this.subjectsAvailable.length);

    this.loadAllTeachers();
    this.loadAllSubjects();
    this.modalRef = this.modalService.show(template);
  }


  private loadAllTeachers(): void {
    this.subscriptions.push(this.teacherService.getTeachers().subscribe(teachersAll => {
      this.teachersAll = teachersAll as Teacher[];
    }));
    this.loadSubjectTeacher();
  }


  private loadSubjectTeacher(): void {
    this.subscriptions.push(this.subjectTeacherService.getAllSubjectTeacher().subscribe(subject => {
      this.subjects = subject as SubjectTeacher[];
    }));
  }


  public _addSubjectTeacher(): void {
    this.subscriptions.push(this.subjectTeacherService.saveSubjectTeacher(this.editableSubjectTeacher).subscribe(() => {
      this.loadAllSubjects();
      this.modalRef.hide();
    }));
  }


  public _openModalConfirm(template: TemplateRef<any>, teacher: Teacher): void {
    debugger;
    this.teacherConfirmId = teacher.userId;
    this.teacherConfirmName = teacher.name;
    this.teacherConfirmSurname = teacher.surname;
    this.modalRef = this.modalService.show(template);
  }

  public checkForSubjects(num: number): void {
    this.loadSubjectTeacher();
    this.busySubjects.splice(0, this.busySubjects.length);
    this.subjectsAvailable.splice(0, this.subjectsAvailable.length);
    for (let subjTeach of this.subjects) {
      if (subjTeach.teacherId == num) {
        this.busySubjects.push(subjTeach.subjectId)
      }
    }


    for (let subj of this.subjectsAll) {
      if (this.busySubjects.length == 0) {
        this.subjectsAvailable.push(subj);
      }
      for (let busy of this.busySubjects) {
        if (subj.id == busy) {
          this.busySubjects.splice(0, 1);
          break;
        }
        this.subjectsAvailable.push(subj);
        break;

      }

    }

  }

}
