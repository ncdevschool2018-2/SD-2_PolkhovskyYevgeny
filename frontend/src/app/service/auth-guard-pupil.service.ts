import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Users} from "../model/users";
import {UsersService} from "./users.service";
import {Location} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardPupilService implements CanActivate{
  private authorizationAccount: Users;
  constructor(private router: Router,private usersService: UsersService,private location: Location,) { }
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
    let decodedJwtData = JSON.parse(decodedJwtJsonData);debugger

      debugger
      if (tr.includes("3" )&& sessionStorage.getItem('user').toString().includes(to)) {
        debugger
        return true;
      } else {
        this.location.back();
        return false;
      }



  }
}
