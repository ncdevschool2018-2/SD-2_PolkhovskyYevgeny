import { Component, OnInit } from '@angular/core';
import {group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit {
groups:group[];
  private subscriptions: Subscription[] = [];

  
  constructor(private groupService: GroupService,
              ) {

  }

  ngOnInit() {
    this.loadGroups();
  }
  /*getGroup():void{
    this.groupService.getGroup()
      .subscribe(group =>this.groups = group);
  }*/
  private loadGroups(): void {

    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      // Parse json response into local array
      this.groups = groups as group[];
      // Check data in console
     //console.log(this.groups);// don't use console.log in angular :)

    }));
  }
}
