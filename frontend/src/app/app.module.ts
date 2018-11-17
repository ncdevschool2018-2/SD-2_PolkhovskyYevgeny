import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {AdminComponent} from './admin/admin.component';
import {GroupComponent} from './group/group.component';
import {AppRoutingModule} from './app-routing.module';
import {SigninComponent} from './signin/signin.component';
import {PupilComponent} from './pupil/pupil.component';
import {TeacherinfoComponent} from './teacherinfo/teacherinfo.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {GroupContentComponent} from './group-content/group-content.component';
import {FormsModule} from "@angular/forms";
import {ModalModule} from "ngx-bootstrap";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import { FooterComponent } from './footer/footer.component';
import {MatNativeDateModule} from '@angular/material';
import {DemoMaterialModule} from './material-module';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { TimetableComponent } from './timetable/timetable.component';
import { TimetableInfoComponent } from './timetable-info/timetable-info.component';
import { TableComponent } from './table/table.component';
import { SubjectsComponent } from './subjects/subjects.component';
import { GoBackComponent } from './go-back/go-back.component';
import { TeachersComponent } from './teachers/teachers.component';
import { TimetableInfoTeacherComponent } from './timetable-info-teacher/timetable-info-teacher.component';
import { TableTeacherComponent } from './table-teacher/table-teacher.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    GroupComponent,
    SigninComponent,
    PupilComponent,
    TeacherinfoComponent,
    GroupContentComponent,
    FooterComponent,
    TimetableComponent,
    TimetableInfoComponent,
    TableComponent,
    SubjectsComponent,
    GoBackComponent,
    TeachersComponent,
    TimetableInfoTeacherComponent,
    TableTeacherComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    HttpClientModule,
    ModalModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot(),
    DemoMaterialModule,
    MatNativeDateModule,


// The HttpClientInMemoryWebApiModule module intercepts HTTP requests
// and returns simulated server responses.
// Remove it when a real server is ready to receive requests.

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
platformBrowserDynamic().bootstrapModule(AppModule);
