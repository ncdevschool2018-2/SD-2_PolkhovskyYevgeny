import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Users} from "../model/users";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardPupilService implements CanActivate{

  constructor(private router: Router,) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let token = sessionStorage.getItem('AuthToken');
    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    let tr = decodedJwtJsonData.split('"')[7];
    let decodedJwtData = JSON.parse(decodedJwtJsonData);
    if (tr.includes("3")) {
      return true;
    } else {
      this.router.navigate(['/signin']);
      return false;
    }

  }
}
