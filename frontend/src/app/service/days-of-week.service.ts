import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DaysOfWeek} from "../model/daysOfWeek";


@Injectable({
  providedIn: 'root'
})
export class DaysOfWeekService {

  constructor(private http: HttpClient) {}
    getDaysOfWeek(): Observable<DaysOfWeek[]> {
      return this.http.get<DaysOfWeek[]>('/api/day-of-week');

  }
}
