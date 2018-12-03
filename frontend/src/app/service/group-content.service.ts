import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {GroupContent} from "../model/GroupContent";


@Injectable({
  providedIn: 'root'
})
export class GroupContentService {

  constructor(private http: HttpClient) {
  }

  getGroupContent(): Observable<GroupContent[]> {
    return this.http.get<GroupContent[]>('/api/pupil');
  }

  saveGroupContent(groupContent: GroupContent): Observable<GroupContent> {
    return this.http.post<GroupContent>('/api/pupil/', groupContent);
  }

  deleteGroupContent(groupContentId: string): Observable<void> {
    return this.http.delete<void>('/api/pupil/' + groupContentId);
  }

  getGroupContentByGroup(id: number): Observable<GroupContent[]> {
    return this.http.get<GroupContent[]>('/api/pupil/group/' + id);
  }
}
