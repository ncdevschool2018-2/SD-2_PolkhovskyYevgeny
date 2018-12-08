import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
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

  getGroupById(id:number):Observable<Group>{
    return this.http.get<Group>('/api/universitygroup/' + id)
  }

  getPageGroups(page: number): Observable<Group[]> {
    return this.http.get<Group[]>('/api/universitygroup/page/' + (page - 1));
  }
  findGroup(word: string): Observable<Group[]> {
    return this.http.get<Group[]>('/api/universitygroup/search/' + word);
  }
  getGroupsNumber(): Observable<number> {
    return this.http.get<number>('/api/universitygroup/totalPages');
  }

}
