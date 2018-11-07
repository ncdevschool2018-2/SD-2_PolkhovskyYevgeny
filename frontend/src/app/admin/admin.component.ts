import {Component, OnInit, TemplateRef} from '@angular/core';
import {Group} from "../model/group";
import {Subscription} from "rxjs/internal/Subscription";
import {GroupService} from "../service/group.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {GroupContentService} from "../service/group-content.service";
import {GroupContent} from "../model/GroupContent";
import {Roles} from "../model/role";
import {RolesService} from "../service/roles.service";
import {UsersService} from "../service/users.service";
import {Users} from "../model/users";
import {FormControl} from "@angular/forms";
import {NewUser} from "../model/newUser";
import {PupilService} from "../service/pupil.service";
import {TeacherService} from "../service/teacher.service";


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {
  myControl = new FormControl();
  public groups: Group[];
  public users: Users[];
  public editableGroup: Group = new Group();
  public editablePupil: GroupContent = new GroupContent();
  public editableUser: Users = new Users();
  public editableNewUser: NewUser = new NewUser();
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  public roles: Roles[];

  viewValue: string;
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
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
        this.loadGroups();                                              // we keep the modal reference and pass the template local name to the modalService.
    /*this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      this.groups = groups as Group[];
    }));*/
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
    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      // Parse json response into local array
      this.groups = groups as Group[];
      // Check data in console
      //console.log(this.groups);// don't use console.log in angular :)
    }));
  }

  public _openModalPupil(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                    // we keep the modal reference and pass the template local name to the modalService.
    this.subscriptions.push(this.rolesService.getRoles().subscribe(roles => {
      this.roles = roles as Roles[];
    }));

  }
  public _openModalTeacher(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                    // we keep the modal reference and pass the template local name to the modalService.
    this.subscriptions.push(this.rolesService.getRoles().subscribe(roles => {
      this.roles = roles as Roles[];
    }));

  }


  public _addPupil(): void {
    this.subscriptions.push(this.groupContentService.saveGroupContent(this.editablePupil).subscribe(() => {
      this._updatePupils();
      this.refreshPupil();
      this.modalRef.hide();
    }));

  }

  public _updatePupils(): void {
    this.loadPupils();
  }

  private refreshPupil(): void {
    this.editablePupil = new GroupContent();
  }

  private loadPupils(): void {
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      // Parse json response into local array
      this.groups = groups as Group[];
    }));
  }

  public _addUser(): void {
    this.subscriptions.push(this.userService.saveUsers(this.editableUser).subscribe(() => {
      this._updateUsers();
      this.refreshUser();
      this._closeModal();
    }));
  }
  public _updateUsers(): void {
    this.loadUsers();
  }
  private refreshUser(): void {
    this.editableUser = new Users();
  }
  private loadUsers(): void {

    // Get data from BillingAccountService
    this.subscriptions.push(this.userService.getUsers().subscribe(users => {
      // Parse json response into local array
      this.users = users as Users[];
    }));
  }
  public _addNewPupil(): void {
    for (let user of this.users){
      this.editableNewUser.userId=user.id+1;
    }
    this.subscriptions.push(this.pupilService.saveNewPupil(this.editableNewUser).subscribe(() => {
      this._updateUsers();


      this._closeModal();
    }));
  }
  public _addNewTeacher(): void {
    for (let user of this.users){
      this.editableNewUser.userId=user.id+1;
    }
    this.subscriptions.push(this.teacherService.saveNewTeacher(this.editableNewUser).subscribe(() => {
      this._updateUsers();


      this._closeModal();
    }));
  }




}
