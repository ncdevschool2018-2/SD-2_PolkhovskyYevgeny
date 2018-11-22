import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teacherinfo',
  templateUrl: './teacherinfo.component.html',
  styleUrls: ['./teacherinfo.component.css']
})
export class TeacherinfoComponent implements OnInit {
  oneAtATime: boolean = true;
  isCollapsed = false;
  isCollapsed1 = false;
  isCollapsed2 = false;
  constructor() { }

  ngOnInit() {
  }

}
