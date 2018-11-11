import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Timetable} from "../model/timetable";
import {Subjects} from "../model/subjects";

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
}
