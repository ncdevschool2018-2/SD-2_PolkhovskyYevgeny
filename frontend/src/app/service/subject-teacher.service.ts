import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {SubjectTeacher} from "../model/subjectTeacher";

@Injectable({
  providedIn: 'root'
})
export class SubjectTeacherService {

  constructor(private http: HttpClient) { }
  getAllSubjectTeacher():Observable<SubjectTeacher[]>{
    return this.http.get<SubjectTeacher[]>('/api/fsubject-teacher')
  }
}
