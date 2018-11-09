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


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {

  public groups: Group[];
  public users: Users[];
  public editableGroup: Group = new Group();
  public timetable: Timetable[];
  public editableNewUser: NewUser = new NewUser();
  public editableTimetable: Timetable = new Timetable();
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  public roles: Roles[];


  readonly radio = new FormControl('1');

  constructor(
    private groupService: GroupService,
    private groupContentService: GroupContentService,
    private modalService: BsModalService,
    private rolesService: RolesService,
    private userService: UsersService,
    private pupilService: PupilService,
    private teacherService: TeacherService,
  ) {
  }

  ngOnInit() {
    this.editableNewUser.roleId = 1;
    this.loadGroups();
    this.loadUsers();
  }

  public _openModal(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.modalRef = this.modalService.show(template);
    this.loadGroups();
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
    this.modalRef = this.modalService.show(template);
    this.subscriptions.push(this.rolesService.getRoles().subscribe(roles => {
      this.roles = roles as Roles[];
    }));

  }
  public _openModalTimetable(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.modalRef = this.modalService.show(template);
    this.subscriptions.push(this.rolesService.getRoles().subscribe(roles => {
      this.roles = roles as Roles[];
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
  private loadSlotId(): void {


    this.subscriptions.push(this.userService.getUsers().subscribe(users => {

      this.users = users as Users[];
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


}
