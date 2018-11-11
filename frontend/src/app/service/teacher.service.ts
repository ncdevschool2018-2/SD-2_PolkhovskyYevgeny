import { Injectable } from '@angular/core';
import {NewUser} from "../model/newUser";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {GroupContent} from "../model/GroupContent";
import {Teacher} from "../model/teacher";

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private http: HttpClient) { }
  saveNewTeacher(newUser: NewUser): Observable<NewUser> {
    return this.http.post<NewUser>('/api/teacher/new-teacher', newUser);
  }

  getTeacher(id :Number): Observable<Teacher>{
    return this.http.get<Teacher>('/api/teacher' + id);
  }
  getTeacherName(sbj:String): Observable<Teacher[]>{
    return this.http.get<Teacher[]>('/api/teacher/chooseTchr/' + sbj);
  }
}
