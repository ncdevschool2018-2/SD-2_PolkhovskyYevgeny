import { Component, OnInit } from '@angular/core';
import {group} from "../model/group";
import {GroupService} from "../group.service";

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit {
groups:group[];


  
  constructor(private groupService: GroupService) {

  }

  ngOnInit() {
    this.getGroup();
  }
  getGroup():void{
    this.groupService.getGroup()
      .subscribe(group =>this.groups = group);
  }

}
