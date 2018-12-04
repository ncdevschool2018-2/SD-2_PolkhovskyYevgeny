import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AccordionConfig} from 'ngx-bootstrap/accordion';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Slots} from "../model/slots";

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
  @Input()
  public slots: Slots[];
  returnedArray: Group[];
  @Input()
  public timetable: boolean;
  public modalRef: BsModalRef;
  public groups: Group[];
  public groupsf: Group[];
  public groupNumber: number;
  public editableGroup: Group = new Group();
  private subscriptions: Subscription[] = [];
  /*page: PageGroup;*/
  currentPage: number = 1;
  public alertGroup: boolean = true;
  public paghide: boolean = false;
  public search: string = "";
  public kj: string = "";
  tChange: boolean=false;
  seasons: string[] = ['Winter', 'Spring', 'Summer', 'Autumn'];
  constructor(private groupService: GroupService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
  ) {

  }

  ngOnInit() {

    this.loadGroups(1);
    this.getNumberOfGroups();


  }

  pageChanged(event: any): void {
    this.loadGroups(event.page);
    //this.page = event.page;
  }




  public k(): void {
    if (this.search.length == 0) {
      this.loadGroups(1);
      this.paghide=false;

    }
    else {

    this.kj = this.search;
    this.subscriptions.push(this.groupService.findGroup(this.kj).subscribe(numb => {
      // Parse json response into local array
      this.groups = numb as Group[];
      this.paghide=true;

    }));
  }
  }

  private loadGroups(page: number): void {

    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getPageGroups(page).subscribe(numb => {
      // Parse json response into local array
      this.groups = numb as Group[];


    }));
  }

  public getNumberOfGroups(): void {
    this.subscriptions.push(this.groupService.getGroupsNumber().subscribe(numOfGroups => {
      this.groupNumber = numOfGroups as number;
    }/*,
      (error => {
        if(error   ){
          alert("you have no any permissions")
        }
      })*/))
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  /*public pageChanged(page:number):void{

  }*/
  public _addGroup(): void {
    debugger
    if (parseInt(this.editableGroup.name) >= 1000000 && parseInt(this.editableGroup.name) <= 99999999) {
      this.subscriptions.push(this.groupService.saveGroup(this.editableGroup).subscribe(() => {
        this._updateGroups();
        this.refreshGroup();
        this.getNumberOfGroups();
        this.modalRef.hide();
      }));
    }
    else {
      this.alertGroup = false;
    }
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
