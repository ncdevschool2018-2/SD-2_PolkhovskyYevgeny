import {Component, OnInit} from '@angular/core';


import {PupilService} from "../service/pupil.service";
import {AuthService} from "../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Slots} from "../model/slots";
import {Subscription} from "rxjs";
import {SlotService} from "../service/slot.service";
import {GroupContent} from "../model/GroupContent";
import {GroupContentService} from "../service/group-content.service";
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";


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
  public student: GroupContent;
  public group: Group;
  public groupId: number;
  tChange: boolean = false;

  constructor(private pupilService: PupilService,
              private authService: AuthService,
              private router: Router,
              private slotService: SlotService,
              private route: ActivatedRoute,
              private groupService: GroupService,
              private groupContentService: GroupContentService,) {
  }

  ngOnInit() {
    this.loadUser();
    this.loadSlot();
    this.getGroupName();


  }

  logout() {
    this.authService.logout();
    this.router.navigateByUrl('/');
  }

  public first(): void {
    this.isCollapsed = false;
    this.isCollapsed1 = true;
    this.isCollapsed2 = true;

  }

  public second(): void {
    this.isCollapsed = true;
    this.isCollapsed1 = false;
    this.isCollapsed2 = true;

  }

  public third(): void {
    this.isCollapsed = true;
    this.isCollapsed1 = true;
    this.isCollapsed2 = false;

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

  private loadUser(): void {

    // Get data from BillingAccountService
    this.route.params.subscribe(params => {
      let id: number = +params['id'];

      this.subscriptions.push(this.groupContentService.getStudentByUserId(id).subscribe(accounts => {
        // Parse json response into local array
        this.student = accounts as GroupContent;
        // Check data in console


      }));
    });

  }

  private getGroupName(): void {

    this.subscriptions.push(this.groupService.getGroupById(this.student.groupId).subscribe(slots => {

        this.group = slots as Group;
      }
      /*,
      (error => {
        if(error==="Unauthorized"   ){
          alert("you have no any permissions")
        }
      })*/));
  }
}
