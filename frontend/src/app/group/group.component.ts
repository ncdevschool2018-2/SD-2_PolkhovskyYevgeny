import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AccordionConfig} from 'ngx-bootstrap/accordion';
import {PageChangedEvent} from 'ngx-bootstrap/pagination';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {PageGroup} from "../model/pageGroup";

export function getAccordionConfig(): AccordionConfig {
  return Object.assign(new AccordionConfig(), {closeOthers: true});
}

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css'],
  providers: [{provide: AccordionConfig, useFactory: getAccordionConfig}]
})
export class GroupComponent implements OnInit {

  returnedArray: Group[];
  @Input()
  public timetable: boolean;
  public modalRef: BsModalRef;
  groups: Group[];
  public editableGroup: Group = new Group();
  private subscriptions: Subscription[] = [];
  page: PageGroup;
  currentPage:number=1;
  
  constructor(private groupService: GroupService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
  ) {

  }

  ngOnInit() {

    this.loadGroups(1);



  }

  /*getGroup():void{
    this.groupService.getGroup()
      .subscribe(Group =>this.groups = Group);
  }*/


  /*pageChanged(event: PageChangedEvent): void {

    const startItem = (event.page - 1) * event.itemsPerPage;
    const endItem = event.page * event.itemsPerPage;
    this.returnedArray = this.groups.slice(startItem, endItem);
  }*/

  /*private loadGroups(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      // Parse json response into local array
      this.groups = groups as Group[];
      this.returnedArray = this.groups.slice(0, 10);
      // Check data in console
      //console.log(this.groups);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
    /!*this.contentArray = this.groups;*!/

  }*/
  private loadGroups(page:number): void {

    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getPageGroups(page).subscribe(page => {
      // Parse json response into local array
      this.page = page as PageGroup;



    }));
    /*this.contentArray = this.groups;*/

  }
  public _closeModal(): void {
    this.modalRef.hide();
  }
  public pageChanged(page:number):void{
    this.loadGroups(page);
  }
  public _addGroup(): void {
    this.subscriptions.push(this.groupService.saveGroup(this.editableGroup).subscribe(() => {
      this._updateGroups();
      this.refreshGroup();
      this.modalRef.hide();
    }));
  }
  public _updateGroups(): void {
    this.loadGroups(this.currentPage);
  }
  private refreshGroup(): void {
    this.editableGroup = new Group();
  }

  public _openModal(template: TemplateRef<any>): void {

    this.modalRef = this.modalService.show(template);

  }
}
