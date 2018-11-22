import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {GroupContent} from "../model/GroupContent";

import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {GroupContentService} from "../service/group-content.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";

@Component({
  selector: 'app-group-content',
  templateUrl: './group-content.component.html',
  styleUrls: ['./group-content.component.css']
})
export class GroupContentComponent implements OnInit {
  @Input()
  public groupNumber:number;

  public groupContent: GroupContent[];
  public editableGC: GroupContent = new GroupContent();

  public modalRef: BsModalRef;
  private subscriptions: Subscription[] = [];
  public groups: Group[];
  public groupId: number;
  public group: string;


  constructor(private groupContentService: GroupContentService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private route: ActivatedRoute,
              private groupService: GroupService,
  ) {
  }

  ngOnInit() {

    this.loadGroups();

    /*this.loadGroupContent();*/
    this.loadGroupsContent();


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

      this.groupContent = accounts as GroupContent[];

    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }


  public _deletePupil(groupContentId: string): void {


    this.subscriptions.push(this.groupContentService.deleteGroupContent(groupContentId).subscribe(() => {
      this._updateGroupContent();
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
}
