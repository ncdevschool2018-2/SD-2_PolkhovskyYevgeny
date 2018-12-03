import {Injectable} from '@angular/core';
import {TokenStorage} from "./token.storage";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {Token} from "../model/token";
import {Users} from "../model/users";


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private messageSource = new BehaviorSubject(new Users());
  currentAuthorizedUser = this.messageSource.asObservable();

  constructor(private http: HttpClient, private token: TokenStorage) {
  }

  attemptAuth(login: string, password: string): Observable<Token> {
    const credentials = {login: login, password: password};
    return this.http.post<Token>('/api/token/generate-token', credentials);
  }

  logout() {
    // remove user from local storage to log user out
    this.token.signOut();
    localStorage.clear();
  }

  transmitAuthorizedUser(user: Users) {
    this.messageSource.next(user);
  }
}
