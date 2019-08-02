import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {MatTableModule} from "@angular/material";
import {MatSortModule} from '@angular/material/sort';

import {AppComponent} from './app.component';
import {LoginComponent} from "./login/LoginComponent";
import {HomeComponent} from "./home/HomeComponent";
import {UserComponent} from "./user/UserComponent";
import {AdminComponent} from "./admin/AdminComponent";
import {httpInterceptorProviders} from "./auth/AuthInterceptor";
import {AccountComponent} from "./account/AccountComponent";
import {TestComponent} from "./user/tests/TestComponent";
import {MaterialModule} from "./MaterialModule";
import {CreateOperatorComponent} from "./admin/operator/createOperatorComponent";
import {CreateCandidateComponent} from "./operator/candidate/CreateCandidateComponent";
import {OperatorComponent} from "./operator/OperatorComponent";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    HomeComponent,
    AdminComponent,
    AccountComponent,
    CreateOperatorComponent,
    TestComponent,
    CreateCandidateComponent,
    OperatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatTableModule,
    MaterialModule,
    HttpClientModule,
    MatSortModule
  ],
  exports: [
    MatTableModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
