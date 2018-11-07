import {Component, OnInit, TemplateRef} from '@angular/core';
import {GroupContent} from "../model/GroupContent";

import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {GroupContentService} from "../service/group-content.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Users} from "../model/users";
import {UsersService} from "../service/users.service";

@Component({
  selector: 'app-group-content',
  templateUrl: './group-content.component.html',
  styleUrls: ['./group-content.component.css']
})
export class GroupContentComponent implements OnInit {
  public groupContent: GroupContent[];
  public editableGC: GroupContent = new GroupContent();
  public editableUser: Users = new Users();
  public modalRef: BsModalRef;
  private subscriptions: Subscription[] = [];
  public groups: Group[];
  public users: Users[];
public  delId:number;
  constructor(private groupContentService: GroupContentService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private route: ActivatedRoute,
              private groupService: GroupService,
              private userService: UsersService) {
  }

  ngOnInit() {
    this.loadGroupContent();
    this.loadUsers();
  }

  private loadGroupContent(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.route.params.subscribe(params => {
      let id: number = +params['id'];
      this.subscriptions.push(this.groupContentService.getGroupContentByGroup(id).subscribe(accounts => {
        // Parse json response into local array
        this.groupContent = accounts as GroupContent[];
        // Check data in console
        this.loadingService.hide();

      }));
    });
    /*this.route.params
      .switchMap((params: Params) => this.groupContentService.getGroupContentByGroup(+params['id']))
      .subscribe(accounts => {
        // Parse json response into local array
        this.groupContent = accounts as GroupContent[];
        // Check data in console
        this.loadingService.hide();

      });*/
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }


  public _deletePupil(groupContentId: string): void {
  debugger;
  for (let gc of this.groupContent) {
      if (gc.id == parseInt(groupContentId, 10)){
        this.delId=gc.userId;
        break;
      }
    }debugger;
    for (let user of this.users) {
      if (user.id == this.delId){
        this._deleteUser(user.id.toString());
        break;
      }
    }
    this.subscriptions.push(this.groupContentService.deleteGroupContent(groupContentId).subscribe(() => {
      this._updateGroupContent();
    }));

  }

  public _updateGroupContent(): void {
    this.loadGroupContent();
  }

  public _openModal(template: TemplateRef<any>, groupContent: GroupContent): void {
    this.loadGroups();


    this.editableGC = GroupContent.cloneBase(groupContent);


    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _addGroupContent(): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupContentService.saveGroupContent(this.editableGC).subscribe(() => {
      this._updateGroupContent();
      this.refreshGC();
      this._closeModal();

      this.loadingService.hide();
    }));
  }

  private refreshGC(): void {
    this.editableGC = new GroupContent();
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

  private loadUsers(): void {
    // Get data from BillingAccountService
    this.subscriptions.push(this.userService.getUsers().subscribe(users => {
      // Parse json response into local array
      this.users = users as Users[];
      // Check data in console
      //console.log(this.groups);// don't use console.log in angular :)
    }));
  }

  public _deleteUser(userId: string): void {

    this.subscriptions.push(this.userService.deleteUsers(userId).subscribe(() => {

    }));
  }
}
