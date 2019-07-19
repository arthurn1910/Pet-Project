import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import {LoginComponent} from "./login/LoginComponent";
import {HomeComponent} from "./home/HomeComponent";
import {UserComponent} from "./user/UserComponent";
import {AdminComponent} from "./admin/AdminComponent";
import {httpInterceptorProviders} from "./auth/AuthInterceptor";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    HomeComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
