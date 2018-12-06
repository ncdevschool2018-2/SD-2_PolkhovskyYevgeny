import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from "./admin/admin.component";
import {SigninComponent} from "./signin/signin.component";
import {GroupComponent} from "./group/group.component";
import {PupilComponent} from "./pupil/pupil.component";
import {TeacherinfoComponent} from "./teacherinfo/teacherinfo.component";
import {GroupContentComponent} from "./group-content/group-content.component";
import {TimetableComponent} from "./timetable/timetable.component";
import {TimetableInfoComponent} from "./timetable-info/timetable-info.component";
import {SubjectsComponent} from "./subjects/subjects.component";
import {TeachersComponent} from "./teachers/teachers.component";
import {TimetableInfoTeacherComponent} from "./timetable-info-teacher/timetable-info-teacher.component";
import {SignupComponent} from "./signup/signup.component";

const routes: Routes = [
  {path: '', redirectTo: '/signin', pathMatch: 'full'},
  {path: 'admin', component: AdminComponent},
  {path: 'signin', component: SigninComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'group', component: GroupComponent},
  {path: 'pupil/:id', component: PupilComponent},
  {path: 'groupContent/:id', component: GroupContentComponent},
  {path: 'timetableinfo/:id', component: TimetableInfoComponent},
  {path: 'timetable-info-teacher/:id', component: TimetableInfoTeacherComponent},
  {path: 'timetable', component: TimetableComponent},
  {path: 'teacherinfo', component: TeacherinfoComponent},
  {path: 'subject', component: SubjectsComponent},
  {path: 'teachers', component: TeachersComponent},
  {path: 'teacherinfo/:id', component: TeacherinfoComponent},

]


@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}
