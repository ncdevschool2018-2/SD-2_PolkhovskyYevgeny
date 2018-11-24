import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {Group} from "../model/group";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GroupService { //todo create interface
  constructor(private http: HttpClient) {
  }
  getGroups(): Observable<Group[]> {
    return this.http.get<Group[]>('/api/universitygroup');
  }

  saveGroup(group: Group): Observable<Group> {
    return this.http.post<Group>('/api/universitygroup', group);
  }

  deleteGroup(groupId: string): Observable<void> {
    return this.http.delete<void>('/api/universitygroup/' + groupId);
  }
  /*getGroup(): Observable<Group[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(GROUP);
  }*/

}
