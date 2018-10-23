import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {group} from "./model/group";
import {GROUP} from "./mock-group";

@Injectable({
  providedIn: 'root'
})
export class GroupService {



  getGroup(): Observable<group[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(GROUP);
  }
  constructor() { }
}
