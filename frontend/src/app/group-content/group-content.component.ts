import { Component, OnInit } from '@angular/core';
import {groupContent} from "../model/groupContent";
import {GroupContentService} from "../group-content.service";

@Component({
  selector: 'app-group-content',
  templateUrl: './group-content.component.html',
  styleUrls: ['./group-content.component.css']
})
export class GroupContentComponent implements OnInit {
  public groupsContent:groupContent[];
  constructor(private groupContentService:GroupContentService) { }

  ngOnInit() {
    this.getGroupContent();
  }
  getGroupContent():void{
    this.groupContentService.getGroupContent()
      .subscribe(groupContent =>this.groupsContent = groupContent);
  }

}
