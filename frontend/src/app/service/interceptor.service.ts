import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";
import {TokenStorage} from "./token.storage";
import {AuthService} from "./auth.service";

const TOKEN_HEADER_KEY = 'Authorization';


@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor {


  constructor(private token: TokenStorage, private router: Router, private authService: AuthService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    if (this.token.getToken() != null) {
      authReq = req.clone({headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this.token.getToken())});
      return next.handle(authReq).pipe(
        catchError(err => {
            if (err.status === 401) {
              this.authService.logout();
              this.router.navigateByUrl('/');
            }

            // if (err.status === 403){
            //   this.router.navigateByUrl('/');
            // }

            const error = err.error.message || err.statusText;
            return throwError(error);
          }
        ));
    }
    return next.handle(authReq).pipe(
      catchError(err => {
          if (err.status === 401) {
            this.authService.logout();
            this.router.navigateByUrl('/');
          }

          // if (err.status === 403){
          //   this.router.navigateByUrl('/');
          // }

          const error = err.error.message || err.statusText;
          return throwError(error);
        }
      ));
  }
}
