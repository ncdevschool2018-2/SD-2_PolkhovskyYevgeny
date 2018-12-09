import { Injectable } from '@angular/core';
import {CanActivate, Router, RouterStateSnapshot, ActivatedRouteSnapshot} from '@angular/router';
import {Token} from "../model/token";
import {Users} from "../model/users";
import {UsersService} from "./users.service";
@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{
  private authorizationAccount: Users;
  constructor(private router: Router,
              private usersService: UsersService,) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let token = sessionStorage.getItem('AuthToken');
    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    let tr = decodedJwtJsonData.split('"')[7];
    let decodedJwtData = JSON.parse(decodedJwtJsonData);
    if (tr.includes("1")) {
      return true;
    } else {
      this.router.navigate(['/signin']);
      return false;
    }
  }
}
