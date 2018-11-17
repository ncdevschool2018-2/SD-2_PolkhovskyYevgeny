import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {SubjectTeacher} from "../model/subjectTeacher";
import {Subjects} from "../model/subjects";

@Injectable({
  providedIn: 'root'
})
export class SubjectTeacherService {

  constructor(private http: HttpClient) { }
  getAllSubjectTeacher():Observable<SubjectTeacher[]>{
    return this.http.get<SubjectTeacher[]>('/api/fsubject-teacher')
  }
  saveSubjectTeacher(subjectTeacher:SubjectTeacher):Observable<SubjectTeacher>{
    return this.http.post<SubjectTeacher>('/api/fsubject-teacher',subjectTeacher);
  }


}
