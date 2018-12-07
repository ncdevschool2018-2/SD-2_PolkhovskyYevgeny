import {Injectable} from '@angular/core';
import {NewUser} from "../model/newUser";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Teacher} from "../model/teacher";
import {PageTeacher} from "../model/pageTeacher";
import {Group} from "../model/group";


@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private http: HttpClient) {
  }

  saveNewTeacher(newUser: NewUser): Observable<NewUser> {
    return this.http.post<NewUser>('/api/teacher/new-teacher', newUser);
  }

  getTeachers(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>('/api/teacher');
  }

  getTeacher(id: Number): Observable<Teacher> {
    return this.http.get<Teacher>('/api/teacher/' + id);
  }

  getTeacherName(sbj: number): Observable<Teacher[]> {
    return this.http.get<Teacher[]>('/api/teacher/chooseTchr/' + sbj);
  }

  deleteTeacher(teacherId: string): Observable<void> {
    return this.http.delete<void>('/api/teacher/' + teacherId);
  }
  findTeacher(word: string): Observable<Teacher[]> {
    return this.http.get<Teacher[]>('/api/teacher/search/' + word);
  }
  getPageTeachers(page: number): Observable<PageTeacher> {
    return this.http.post<PageTeacher>('/api/teacher/page', page - 1);
  }
}
