import { Component, OnInit } from '@angular/core';


import {PupilService} from "../service/pupil.service";

@Component({
  selector: 'app-pupil',
  templateUrl: './pupil.component.html',
  styleUrls: ['./pupil.component.css']
})
export class PupilComponent implements OnInit {

  constructor(private pupilService: PupilService) { }

  ngOnInit() {

  }


}
