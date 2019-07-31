import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from "@angular/material";

import { AppComponent } from './app.component';
import {LoginComponent} from "./login/LoginComponent";
import {HomeComponent} from "./home/HomeComponent";
import {UserComponent} from "./user/UserComponent";
import {AdminComponent} from "./admin/AdminComponent";
import {httpInterceptorProviders} from "./auth/AuthInterceptor";
import {AccountComponent} from "./account/AccountComponent";
import {OperatorComponent} from "./admin/operator/operatorComponent";
import {TestComponent} from "./user/tests/TestComponent";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    HomeComponent,
    AdminComponent,
    AccountComponent,
    OperatorComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatTableModule,
    HttpClientModule
  ],
  exports: [
    MatTableModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
