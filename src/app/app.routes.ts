import {RouterModule, Routes} from '@angular/router';
import {LoginPanelComponent} from "./login-panel/login-panel.component";
import {LoginComponent} from "./login/login.component";
import {NgModule} from "@angular/core";
import {MainPageComponent} from "./main-page/main-page.component";

export const routes: Routes = [
  {
    path: 'create',
    title: 'Create Account',
    component: LoginPanelComponent,
  },
  {
    path: 'login',
    title: 'Login',
    component: LoginComponent,
  },
  {
    path:'main',
    title:'Main Page',
    component:MainPageComponent,
  },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutes{}
