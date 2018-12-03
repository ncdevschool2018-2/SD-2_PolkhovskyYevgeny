import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {SubjectService} from "../service/subject.service";
import {Subjects} from "../model/subjects";


@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: ['./subjects.component.css']
})
export class SubjectsComponent implements OnInit {

  public subject: Subjects[];
  public modalRef: BsModalRef;
  private subscriptions: Subscription[] = [];
  public editableSubject: Subjects = new Subjects();
  public subjectsAll: Subjects[];

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private subjectService: SubjectService,
              private modalService: BsModalService,) {
  }

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

  public _openModalSubject(template: TemplateRef<any>): void {
    //this.refreshSubject();
    this.modalRef = this.modalService.show(template);
    //this.loadGroups();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _addSubject(): void {
    this.subscriptions.push(this.subjectService.saveSubject(this.editableSubject).subscribe(() => {
      this.loadAllSubjects();
      this._updateSubject();
      this.modalRef.hide();
    }));
  }

  private loadAllSubjects(): void {


    this.subscriptions.push(this.subjectService.getSubjectsAll().subscribe(subjectsAll => {

      this.subjectsAll = subjectsAll as Subjects[];
    }));
  }
}
