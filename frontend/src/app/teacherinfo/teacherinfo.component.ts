import {Component, OnInit} from '@angular/core';
import { Subscription} from "rxjs";
import {GroupService} from "../service/group.service";
import {PageGroup} from "../model/pageGroup";
import {GroupContent} from "../model/GroupContent";
import {ActivatedRoute, Router} from "@angular/router";
import {TeacherService} from "../service/teacher.service";
import {Teacher} from "../model/teacher";
import {AuthService} from "../service/auth.service";
import {Slots} from "../model/slots";
import {SlotService} from "../service/slot.service";
import {SubjectTeacherService} from "../service/subject-teacher.service";
import {SubjectTeacher} from "../model/subjectTeacher";
import {SubjectService} from "../service/subject.service";
import {Subjects} from "../model/subjects";


@Component({
  selector: 'app-teacherinfo',
  templateUrl: './teacherinfo.component.html',
  styleUrls: ['./teacherinfo.component.css']
})
export class TeacherinfoComponent implements OnInit {
  oneAtATime: boolean = true;
  isCollapsed = false;
  isCollapsed1 = true;
  isCollapsed2 = true;
  private subscriptions: Subscription[] = [];
  page: PageGroup;
  currentPage: number = 1;
  tChange: boolean=false;
  public slots: Slots[];
  public subjectTeacher:SubjectTeacher[]=[];
  public subjects:Subjects[];
public teacher:Teacher;
public subjectsOfTeacher:Subjects[]=[];
public teachnumber:number;
  constructor(private teacherService:TeacherService,
              private route: ActivatedRoute,
              private authService: AuthService,
              private router: Router,
              private slotService: SlotService,
              private subjectTeacherService:SubjectTeacherService,
              private subjectService:SubjectService
              ) {
  }

  ngOnInit() {this.loadUser();
    this.loadSubjectTeacher();
    this.loadSubject();

    this.loadSlot();
    this.getTeacherSubjects();
  }
  private getTeacherSubjects():void{
    for(let st of this.subjectTeacher){
      if(st.teacherId==this.teachnumber){
        for(let s of this.subjects){
          if(s.id==st.subjectId){
            this.subjectsOfTeacher.push(s)
          }
        }
      }
    }

  }
  private loadSubjectTeacher():void{
    this.subscriptions.push(this.subjectTeacherService.getAllSubjectTeacher().subscribe(subtea => {

      this.subjectTeacher = subtea as SubjectTeacher[];
    }));
  }
  private loadSubject():void{
    this.subscriptions.push(this.subjectService.getSubjectsAll().subscribe(subtea => {

      this.subjects = subtea as Subjects[];
    }));
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
this.teachnumber=id;
      this.subscriptions.push(this.teacherService.getTeacherByUserId(id).subscribe(accounts => {
        // Parse json response into local array
        this.teacher = accounts as Teacher;
        // Check data in console


      }));
    });

  }
  logout() {
    this.authService.logout();
    this.router.navigateByUrl('/');
  }
  /*this.contentArray = this.groups;*/
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

}
