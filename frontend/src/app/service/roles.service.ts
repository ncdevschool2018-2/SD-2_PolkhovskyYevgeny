import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Roles} from "../model/role";
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class RolesService {

  constructor(private http: HttpClient) {
  }

  getRoles(): Observable<Roles[]> {
    return this.http.get<Roles[]>('/api/role');
  }

  saveRoles(role: Roles): Observable<Roles> {
    return this.http.post<Roles>('/api/role', role);
  }

  deleteRoles(roleId: string): Observable<void> {
    return this.http.delete<void>('/api/role/' + roleId);
  }
}
