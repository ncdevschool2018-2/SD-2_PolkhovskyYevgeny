import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {GroupContent} from "../model/GroupContent";

import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {GroupContentService} from "../service/group-content.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Roles} from "../model/role";
import {RolesService} from "../service/roles.service";
import {NewUser} from "../model/newUser";
import {PupilService} from "../service/pupil.service";
import {Users} from "../model/users";
import {UsersService} from "../service/users.service";
import {Teacher} from "../model/teacher";


@Component({
  selector: 'app-group-content',
  templateUrl: './group-content.component.html',
  styleUrls: ['./group-content.component.css']
})
export class GroupContentComponent implements OnInit {
  @Input()
  public groupNumber: number;
  @Input()
  public roleIdCheck: number = 1;

  public GroupContent: GroupContent[];
  public editableGC: GroupContent = new GroupContent();
  public studentConfirmId: number;
  public studentConfirmName: string;
  public studentConfirmSurname: string;
  public modalRef: BsModalRef;
  public editableGroup: Group = new Group();
  public editableNewUser: NewUser = new NewUser();
  private subscriptions: Subscription[] = [];
  public groups: Group[];
  public groupId: number;
  public group: string;
  public roles: Roles[];
  public users: Users[];
  public buttonHide: boolean = false;
  public searchSur: string = "";
  public searchName: string = "";
  public ss: string = "";
  public sn: string = "";
  constructor(private groupContentService: GroupContentService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private route: ActivatedRoute,
              private groupService: GroupService,
              private rolesService: RolesService,
              private pupilService: PupilService,
              private userService: UsersService,
  ) {
  }

  ngOnInit() {
    this.getButtonHide();
    this.loadGroups();

    /*this.loadGroupContent();*/
    this.loadGroupsContent();


  }

  public k(): void {
    if (this.searchSur.length == 0 && this.searchName.length ==0) {
      this.loadGroupsContent();
      //this.paghide = false;

    }
    else if(this.searchSur.length == 0){

      this.sn = this.searchName;
      this.subscriptions.push(this.groupContentService.findPupilByName(this.sn,this.groupNumber).subscribe(numb => {
        // Parse json response into local array
        this.GroupContent = numb as GroupContent[];
        //this.paghide = true;

      }));
    }
    else if(this.searchName.length ==0){
      this.ss = this.searchSur;

      this.subscriptions.push(this.groupContentService.findPupilBySurname(this.ss,this.groupNumber).subscribe(numb => {
        // Parse json response into local array
        this.GroupContent = numb as GroupContent[];
        //this.paghide = true;

      }));
    }
    else {

      this.ss = this.searchSur;
      this.sn = this.searchName;
      this.subscriptions.push(this.groupContentService.findPupilBySurnameAndName(this.ss,this.sn,this.groupNumber).subscribe(numb => {
        // Parse json response into local array
        this.GroupContent = numb as GroupContent[];
        //this.paghide = true;

      }));
    }
  }

  /*private loadGroupContent(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.route.params.subscribe(params => {
      let id: number = +params['id'];

      this.groupId = id;


      this.subscriptions.push(this.groupContentService.getGroupContentByGroup(id).subscribe(accounts => {
        // Parse json response into local array
        this.groupContent = accounts as GroupContent[];
        // Check data in console
        this.loadingService.hide();

      }));
    });

  }*/
  private loadGroupsContent(): void {

    this.subscriptions.push(this.groupContentService.getGroupContentByGroup(this.groupNumber).subscribe(accounts => {

      this.GroupContent = accounts as GroupContent[];

    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public getButtonHide(): void {
    if (this.roleIdCheck == 3) {
      this.buttonHide = true;
    }
  }


  public _deletePupil(groupContentId: string): void {


    this.subscriptions.push(this.groupContentService.deleteGroupContent(groupContentId).subscribe(() => {
      this._updateGroupContent();
      this._closeModal();
    }));

  }

  public _updateGroupContent(): void {
    this.loadGroupsContent();
  }

  public _openModal(template: TemplateRef<any>, groupContent: GroupContent): void {
    this.loadGroups();
    this.editableGC = GroupContent.cloneBase(groupContent);
    this.modalRef = this.modalService.show(template);
  }

  public _openModalConfirm(template: TemplateRef<any>, groupContent: GroupContent): void {
    this.studentConfirmId = groupContent.id;
    this.studentConfirmName = groupContent.name;
    this.studentConfirmSurname = groupContent.surname;

    this.modalRef = this.modalService.show(template);
  }

  public _addGroupContent(): void {
    let expr = /^[a-zA-Z]{3,15}$/;
    if (expr.test(this.editableGC.name) &&
      expr.test(this.editableGC.surname)
    ) {
      this.loadingService.show();
      this.subscriptions.push(this.groupContentService.saveGroupContent(this.editableGC).subscribe(n => {
        if(n== null){
          alert("user with this login already exist");
          return
        }
        this._updateGroupContent();
        this.refreshGC();
        this._closeModal();

        this.loadingService.hide();
      }));
    }
  }

  private refreshGC(): void {
    this.editableGC = new GroupContent();
  }

  private loadGroups(): void {

    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {

      this.groups = groups as Group[];

    }));
  }

  private getGroup(id: number): void {
    for (let group of this.groups) {

      if (group.id == id) {
        this.group = group.name;

      }
    }
  }

  public _openModalPupil(template: TemplateRef<any>): void {
    this.refreshGroup();
    this.modalRef = this.modalService.show(template);
    this.subscriptions.push(this.rolesService.getRoles().subscribe(roles => {
      this.roles = roles as Roles[];
    }));

  }

  private refreshGroup(): void {
    this.editableGroup = new Group();
  }

  public _addNewPupil(): void {
    debugger
    let expr = /^[a-zA-Z]{3,15}$/;
    let exprd = /^[a-zA-Z0-9]{3,15}$/;
    let g = expr.test(this.editableNewUser.name);
    let k = expr.test(this.editableNewUser.surname);
    let m = exprd.test(this.editableNewUser.login);
    let t = exprd.test(this.editableNewUser.password);
    if ((expr.test(this.editableNewUser.name) &&
      expr.test(this.editableNewUser.surname) &&
      exprd.test(this.editableNewUser.login) &&
      exprd.test(this.editableNewUser.password))) {
      this.editableNewUser.groupId = this.groupNumber;
      this.editableNewUser.roleId = 3;
      this.subscriptions.push(this.pupilService.saveNewPupil(this.editableNewUser).subscribe(n => {
        if(n== null){
          alert("user with this login already exist");
          return
        }
        this._updateUsers();
        this.loadGroupsContent();


        this._closeModal();
      }));
    }
  }

  public _updateUsers(): void {
    this.loadUsers();
  }

  private loadUsers(): void {


    this.subscriptions.push(this.userService.getUsers().subscribe(users => {

      this.users = users as Users[];
    }));
  }
}
