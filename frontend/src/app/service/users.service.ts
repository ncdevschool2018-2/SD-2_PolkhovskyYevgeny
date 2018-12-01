import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Users} from "../model/users";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }
  getUsers(): Observable<Users[]> {
    return this.http.get<Users[]>('/api/user');
  }

  saveUsers(user: Users): Observable<Users> {
    return this.http.post<Users>('/api/user', user);
  }

  deleteUsers(userId: string): Observable<void> {
    return this.http.delete<void>('/api/user/' + userId);
  }

  getUserByLogin(login: string): Observable<Users> {
    return this.http.get<Users>("/api/user/auth?login=" + login);
  }

}
