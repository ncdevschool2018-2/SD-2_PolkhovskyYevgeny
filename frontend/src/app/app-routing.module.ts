import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent} from "./admin/admin.component";
import {SigninComponent} from "./signin/signin.component";
import {GroupComponent} from "./group/group.component";
import {PupilComponent} from "./pupil/pupil.component";
import {TeacherinfoComponent} from "./teacherinfo/teacherinfo.component";
import {GroupContentComponent} from "./group-content/group-content.component";

const routes: Routes = [
  {path:'',redirectTo:'/signin', pathMatch: 'full'},
  {path:'admin', component: AdminComponent},
  {path:'signin',component: SigninComponent},
  {path:'group', component: GroupComponent},
  {path:'pupil', component: PupilComponent},
  {path:'groupContent', component: GroupContentComponent},
  {path:'teacherinfo', component: TeacherinfoComponent}
]
@NgModule({
  exports: [ RouterModule ],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {}
