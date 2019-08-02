import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/LoginComponent";
import {AdminComponent} from "./admin/AdminComponent";
import {HomeComponent} from "./home/HomeComponent";
import {AccountComponent} from "./account/AccountComponent";
import {CreateOperatorComponent} from "./admin/operator/createOperatorComponent";
import {TestComponent} from "./user/tests/TestComponent";
import {OperatorComponent} from "./operator/OperatorComponent";
import {CreateCandidateComponent} from "./operator/candidate/CreateCandidateComponent";

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
    path: 'operator',
    component: OperatorComponent
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
    component: CreateOperatorComponent
  },
  {
    path: 'createCandidate',
    component: CreateCandidateComponent
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
export class AppRoutingModule {
}
