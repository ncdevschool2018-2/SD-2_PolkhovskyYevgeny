import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent} from "./admin/admin.component";
import {SigninComponent} from "./signin/signin.component";
import {GroupComponent} from "./group/group.component";
import {PupilComponent} from "./pupil/pupil.component";
import {TeacherinfoComponent} from "./teacherinfo/teacherinfo.component";
import {GroupContentComponent} from "./group-content/group-content.component";
import {TimetableComponent} from "./timetable/timetable.component";
import {TimetableInfoComponent} from "./timetable-info/timetable-info.component";
import {SubjectsComponent} from "./subjects/subjects.component";

const routes: Routes = [
  {path:'',redirectTo:'/signin', pathMatch: 'full'},
  {path:'admin', component: AdminComponent},
  {path:'signin',component: SigninComponent},
  {path:'group', component: GroupComponent},
  {path:'pupil', component: PupilComponent},
  {path:'groupContent/:id', component: GroupContentComponent},
  {path:'timetableinfo/:id', component: TimetableInfoComponent},
  {path:'timetable', component: TimetableComponent},
  {path:'teacherinfo', component: TeacherinfoComponent},
  {path:'subject', component: SubjectsComponent},
  {path:'teacherinfo/:id', component: TeacherinfoComponent},

]
@NgModule({
  exports: [ RouterModule ],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {}
