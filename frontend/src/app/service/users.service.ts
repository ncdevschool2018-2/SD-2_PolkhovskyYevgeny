import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Users} from "../model/users";
import {UsersChange} from "../model/userChange";


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<Users[]> {
    return this.http.get<Users[]>('/api/user');
  }

  getUserById(id: number): Observable<Users> {
    return this.http.get<Users>("/api/user/" + id);
  }

  saveUsers(user: Users): Observable<Users> {
    return this.http.post<Users>('/api/user', user);
  }

  saveEditUsers(user: UsersChange): Observable<UsersChange> {
    return this.http.post<UsersChange>('/api/user/edit', user);
  }

  deleteUsers(userId: string): Observable<void> {
    return this.http.delete<void>('/api/user/' + userId);
  }

  getUserByLogin(login: string): Observable<Users> {
    return this.http.get<Users>("/api/user/auth?login=" + login);
  }

}
