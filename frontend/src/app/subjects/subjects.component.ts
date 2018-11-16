import { Component, OnInit } from '@angular/core';
import {BsModalRef} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {SubjectService} from "../service/subject.service";
import {Group} from "../model/group";
import {Subjects} from "../model/subjects";

@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: ['./subjects.component.css']
})
export class SubjectsComponent implements OnInit {

  public subject: Subjects[];

  private subscriptions: Subscription[] = [];
  constructor(private loadingService: Ng4LoadingSpinnerService,
              private subjectService:SubjectService,) { }

  ngOnInit() {
    this.loadSubject();
  }
  public _deleteSubject(subjectId: string): void {


    this.subscriptions.push(this.subjectService.deleteSubject(subjectId).subscribe(() => {
      this._updateSubject();
    }));

  }
  public _updateSubject(): void {
    this.loadSubject();
  }
  private loadSubject(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.subjectService.getSubjectsAll().subscribe(subject => {
      // Parse json response into local array
      this.subject = subject as Subjects[];
      // Check data in console
      //console.log(this.groups);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }
}
