import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Subjects} from "../model/subjects";


@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  constructor(private http: HttpClient) {
  }

  getSubject(): Observable<Subjects[]> {
    return this.http.get<Subjects[]>('/api/subject/dist');
  }

  getTeacherId(sub: String): Observable<Number[]> {
    return this.http.get<Number[]>("/chooseId/" + sub);
  }

  getSubjectsAll(): Observable<Subjects[]> {
    return this.http.get<Subjects[]>('/api/subject');
  }

  saveSubject(subject: Subjects): Observable<Subjects> {
    return this.http.post<Subjects>('/api/subject', subject);
  }

  deleteSubject(subjectId: string): Observable<void> {
    return this.http.delete<void>('/api/subject/' + subjectId);
  }

  getTeacherSubjects(teacherId: number): Observable<Subjects[]> {
    return this.http.get<Subjects[]>('/api/fsubject-teacher/' + teacherId);
  }

  getSubjectsForTeacher(teacherId: number): Observable<Subjects[]> {
    return this.http.get<Subjects[]>('/api/subject/teacher/' + teacherId);
  }
}
