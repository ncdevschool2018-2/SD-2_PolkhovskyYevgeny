import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Location} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardTeacherService implements CanActivate{

  constructor(private router: Router,
              private location: Location,) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let to=state.url.split("/")[2];
    let token = sessionStorage.getItem('AuthToken');
    if(token==null){
      //this.router.navigate(['/signin']);

      this.location.back();

      return false
    }
    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    let tr = decodedJwtJsonData.split('"')[7];
    let decodedJwtData = JSON.parse(decodedJwtJsonData);
    if (tr.includes("2")&& sessionStorage.getItem('user').toString().includes(to)) {
      return true;
    } else {
      this.location.back();
      return false;
    }
  }
}
