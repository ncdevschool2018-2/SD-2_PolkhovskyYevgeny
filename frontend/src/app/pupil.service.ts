import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {group} from "./model/group";
import {GROUP} from "./mock-group";
import {FRIDAY, MONDAY, THURSDAY, TUESDAY, WEDNESDAY} from "./mock-timetable";
import {friday, monday, thursday, tuesday, wednesday} from "./model/timetable";

@Injectable({
  providedIn: 'root'
})
export class PupilService {
  getMonday(): Observable<monday[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(MONDAY);
  }

  getTuesday(): Observable<tuesday[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(TUESDAY);
  }

  getThursday(): Observable<thursday[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(THURSDAY);
  }

  getFriday(): Observable<friday[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(FRIDAY);
  }

  getWednesday(): Observable<wednesday[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(WEDNESDAY);
  }
  constructor() { }
}
