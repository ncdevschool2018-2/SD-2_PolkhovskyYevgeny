import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {group} from "./model/group";
import {GROUP} from "./mock-group";
import {groupContent} from "./model/groupContent";
import {firstGroup} from "./mock-groupContent";
import {catchError, tap} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class GroupContentService {
  private groupsContentUrl = 'api/groupContent';
  getGroupContent(): Observable<groupContent[]> {
    // TODO: send the message _after_ fetching the heroes
    //this.messageService.add('HeroService: fetched heroes');
    return of(firstGroup);
  }
  /** POST: add a new hero to the server */
  addGroupContent (gc: groupContent): Observable<groupContent> {
    return this.http.post<groupContent>(this.groupsContentUrl, gc, httpOptions).pipe(
      tap((gc: groupContent) => this.log(`added hero w/ id=${gc.id}`)),
      catchError(this.handleError<groupContent>('addHero'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  private log(message: string) {
    //this.messageService.add(`HeroService: ${message}`);
  }
  constructor(private http: HttpClient,) { }
}
