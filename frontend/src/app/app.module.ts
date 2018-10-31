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


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    GroupComponent,
    SigninComponent,
    PupilComponent,
    TeacherinfoComponent,
    GroupContentComponent,
    FooterComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    HttpClientModule,
    ModalModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot(),

// The HttpClientInMemoryWebApiModule module intercepts HTTP requests
// and returns simulated server responses.
// Remove it when a real server is ready to receive requests.

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
