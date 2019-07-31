import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/LoginComponent";
import {AdminComponent} from "./admin/AdminComponent";
import {HomeComponent} from "./home/HomeComponent";
import {AccountComponent} from "./account/AccountComponent";
import {OperatorComponent} from "./admin/operator/operatorComponent";
import {TestComponent} from "./user/tests/TestComponent";

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'admin',
    component: AdminComponent
  },
  {
    path: 'auth/login',
    component: LoginComponent
  },
  {
    path: 'settings',
    component: AccountComponent
  },
  {
    path: 'createAccount',
    component: OperatorComponent
  },
  {
    path: 'test',
    component: TestComponent
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
