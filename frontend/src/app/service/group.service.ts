import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {group} from "../model/group";
import {GROUP} from "../mock-group";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GroupService { //todo create interface
  constructor(private http: HttpClient) {
  }


  getGroups(): Observable<group[]> {
    return this.http.get<group[]>('/api/group');
  }

  saveGroup(group: group): Observable<group> {
    return this.http.post<group>('/api/group', group);
  }

  deleteGroup(groupId: string): Observable<void> {
    return this.http.delete<void>('/api/group/' + groupId);
  }
  /*getGroup(): Observable<group[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(GROUP);
  }*/

}
