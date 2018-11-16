import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Timetable} from "../model/timetable";
import {Subjects} from "../model/subjects";
import {Group} from "../model/group";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  constructor(private http: HttpClient) { }

  getSubject(): Observable<Subjects[]> {
    return this.http.get<Subjects[]>('/api/subject/dist');
  }
  getTeacherId(sub:String):Observable<Number[]>{
    return this.http.get<Number[]>("/chooseId/"+sub);
  }
  getSubjectsAll(): Observable<Subjects[]> {
    return this.http.get<Subjects[]>('/api/subject');
  }
  saveSubject(subject: Subjects): Observable<Subjects> {
    return this.http.post<Subjects>('/api/subject', subject);
  }
}
