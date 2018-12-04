import {Component, OnInit} from '@angular/core';


import {PupilService} from "../service/pupil.service";
import {AuthService} from "../service/auth.service";
import {Router} from "@angular/router";
import {Slots} from "../model/slots";
import {Subscription} from "rxjs";
import {SlotService} from "../service/slot.service";


@Component({
  selector: 'app-pupil',
  templateUrl: './pupil.component.html',
  styleUrls: ['./pupil.component.css']
})
export class PupilComponent implements OnInit {
  public isCollapsed = false;
  public isCollapsed1 = true;
  public isCollapsed2 = true;
  private subscriptions: Subscription[] = [];
  public slots: Slots[];
  constructor(private pupilService: PupilService,
              private authService: AuthService,
              private router: Router,
              private slotService: SlotService,) {
  }

  ngOnInit() {
this.loadSlot();
  }
  logout() {
    this.authService.logout();
    this.router.navigateByUrl('/');
  }
  public first(): void {
    this.isCollapsed = !this.isCollapsed;
    this.isCollapsed1 = true;
    this.isCollapsed2 = true;

  }

  public second(): void {
    this.isCollapsed = true;
    this.isCollapsed1 = !this.isCollapsed1;
    this.isCollapsed2 = true;

  }

  public third(): void {
    this.isCollapsed = true;
    this.isCollapsed1 = true;
    this.isCollapsed2 = !this.isCollapsed2;

  }
  private loadSlot(): void {

    this.subscriptions.push(this.slotService.getSlot().subscribe(slots => {

        this.slots = slots as Slots[];
      }
      /*,
      (error => {
        if(error==="Unauthorized"   ){
          alert("you have no any permissions")
        }
      })*/));
  }
}
