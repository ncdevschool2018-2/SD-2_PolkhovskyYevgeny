import {Component, Input, OnInit} from '@angular/core';
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import { AccordionConfig } from 'ngx-bootstrap/accordion';
import { PageChangedEvent } from 'ngx-bootstrap/pagination';
import {daLocale} from "ngx-bootstrap";
export function getAccordionConfig(): AccordionConfig {
  return Object.assign(new AccordionConfig(), { closeOthers: true });
}
@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css'],
  providers: [{ provide: AccordionConfig, useFactory: getAccordionConfig }]
})
export class GroupComponent implements OnInit {

  returnedArray: Group[];
  @Input()
  public timetable: boolean;

  groups: Group[];
  private subscriptions: Subscription[] = [];
private page:number=0;
private groupsArray:Array<any>;

  constructor(private groupService: GroupService,
              private loadingService: Ng4LoadingSpinnerService,
  ) {

  }

  ngOnInit() {

    this.loadGroups();
this.pageChanged(new class implements PageChangedEvent {
  itemsPerPage: number=10;
  page: number=1;
})

    this.returnedArray = this.groups.slice(0, 10);

  }

  /*getGroup():void{
    this.groupService.getGroup()
      .subscribe(Group =>this.groups = Group);
  }*/



  pageChanged(event: PageChangedEvent): void {

    const startItem = (event.page - 1) * event.itemsPerPage;
    const endItem = event.page * event.itemsPerPage;
    this.returnedArray = this.groups.slice(startItem, endItem);
  }

  private loadGroups(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      // Parse json response into local array
      this.groups = groups as Group[];
      // Check data in console
      //console.log(this.groups);// don't use console.log in angular :)
      this.loadingService.hide();
    }));/*this.contentArray = this.groups;*/

  }

}
