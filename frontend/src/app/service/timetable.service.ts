import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Timetable} from "../model/timetable";

@Injectable({
  providedIn: 'root'
})
export class TimetableService {

  constructor(private http: HttpClient) {
  }

  getTimetable(): Observable<Timetable[]> {
    return this.http.get<Timetable[]>('/api/timetable');
  }

  saveTimetable(timetable: Timetable): Observable<Timetable> {
    return this.http.post<Timetable>('/api/timetable', timetable);
  }
  getTimetableByGroupId(id:number):Observable<Timetable[]>{
    return this.http.get<Timetable[]>('api/timetable/group/'+id);
  }

}
