import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DaysOfWeek} from "../model/daysOfWeek";
import {Slots} from "../model/slots";

@Injectable({
  providedIn: 'root'
})
export class SlotService {

  constructor(private http: HttpClient) {

  }
  getSlot(): Observable<Slots[]> {
    return this.http.get<Slots[]>('/api/slot');}
}
