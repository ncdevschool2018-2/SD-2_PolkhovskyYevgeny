import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";

import {Users} from "../model/users";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AuthService} from "../service/auth.service";
import {Token} from "../model/token";
import {TokenStorage} from "../service/token.storage";
import {UsersService} from "../service/users.service";
import {Router} from "@angular/router";
import {AuthGuardService} from "../service/auth-guard.service";


@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit, OnDestroy {

  public alertUserAboutError: boolean = false;

  public login: string;
  public password: string;

  private subscriptions: Subscription[] = [];
  private authorizationAccount: Users;

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private authService: AuthService,
              private tokeStorage: TokenStorage,
              private usersService: UsersService,
              private router: Router,
              private authGuardService:AuthGuardService,
  ) {
  }

  ngOnInit() {
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public authorization(): void {

    this.loadingService.show();

    debugger;
    this.subscriptions.push(this.authService.attemptAuth(this.login, this.password).subscribe(authToken => {
      let token: Token = authToken as Token;
      this.tokeStorage.saveToken(token.token);
      let jwtData = token.token.split('.')[1];
      let decodedJwtJsonData = window.atob(jwtData);
      let decodedJwtData = JSON.parse(decodedJwtJsonData);
      console.log(decodedJwtData);

      this.usersService.getUserByLogin(decodedJwtData.sub).subscribe(user => {
        this.authorizationAccount = user as Users;

        console.log(this.authorizationAccount);

        if (this.authorizationAccount.roleId==1) {
          this.authService.transmitAuthorizedUser(this.authorizationAccount);

          this.router.navigate(['admin']);
        } else if (this.authorizationAccount.roleId==2) {
          this.authService.transmitAuthorizedUser(this.authorizationAccount);

          this.router.navigate(['admin']);
        }else if (this.authorizationAccount.roleId==3) {
          this.authService.transmitAuthorizedUser(this.authorizationAccount);

          this.router.navigate(['pupil']);
        }

        this.loadingService.hide();
      });
    }));
  }

  public nav(): void {
    this.router.navigate(['signup']);
  }
}
