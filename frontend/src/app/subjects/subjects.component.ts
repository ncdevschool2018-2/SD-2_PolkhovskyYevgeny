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
  public search: string = "";
  public subjectConfirmId: number;
  currentPage: number = 1;
  public subjectNumber: number;
  public paghide: boolean = false;
  public kj: string = "";

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private subjectService: SubjectService,
              private modalService: BsModalService,) {
  }

  ngOnInit() {
    this.loadSubject(1);
    this.getNumberOfSubjects();
  }

  public k(): void {
    if (this.search.length == 0) {
      this.loadSubject(1);
      this.paghide = false;

    }
    else {

      this.kj = this.search;
      this.subscriptions.push(this.subjectService.findSubject(this.kj).subscribe(numb => {
        // Parse json response into local array
        this.subject = numb as Subjects[];
        this.paghide = true;

      }));
    }
  }

  pageChanged(event: any): void {
    this.loadSubject(event.page);
    //this.page = event.page;
  }

  public getNumberOfSubjects(): void {
    this.subscriptions.push(this.subjectService.getSubjectsNumber().subscribe(numOfGroups => {
      this.subjectNumber = numOfGroups as number;
    }/*,
      (error => {
        if(error   ){
          alert("you have no any permissions")
        }
      })*/))
  }

  public _deleteSubject(subjectId: string): void {


    this.subscriptions.push(this.subjectService.deleteSubject(subjectId).subscribe(() => {
      this._updateSubject();
      this.getNumberOfSubjects();
      this._closeModal();
    }));

  }

  public _openModalConfirm(template: TemplateRef<any>, subject: Subjects): void {
    this.subjectConfirmId = subject.id;


    this.modalRef = this.modalService.show(template);
  }

  public _updateSubject(): void {
    this.loadSubject(this.currentPage);
  }

  private loadSubject(page: number): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.subjectService.getPageSubjects(page).subscribe(subject => {
      // Parse json response into local array
      this.subject = subject as Subjects[];
      // Check data in console
      //console.log(this.groups);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  public _openModalSubject(template: TemplateRef<any>): void {
    this.editableSubject = new Subjects();
    this.modalRef = this.modalService.show(template);
    //this.loadGroups();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _addSubject(): void {
    if (this.editableSubject.subject) {
      this.subscriptions.push(this.subjectService.saveSubject(this.editableSubject).subscribe(n => {
        if (n == null) {
          alert("this subject already exist or name non valid");
          return
        }
        this.loadAllSubjects();
        this._updateSubject();
        this.getNumberOfSubjects();
        this.modalRef.hide();
      }));
    }
  }

  private loadAllSubjects(): void {


    this.subscriptions.push(this.subjectService.getSubjectsAll().subscribe(subjectsAll => {

      this.subjectsAll = subjectsAll as Subjects[];
    }));
  }
}
