import { Injectable } from '@angular/core';
import {NewUser} from "../model/newUser";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private http: HttpClient) { }
  saveNewTeacher(newUser: NewUser): Observable<NewUser> {
    return this.http.post<NewUser>('/api/pupil/new-teacher', newUser);
  }
}
