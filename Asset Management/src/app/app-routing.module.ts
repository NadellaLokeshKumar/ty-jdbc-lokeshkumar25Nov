import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuardService } from './auth-guard.service';
import { UserComponent } from './user/user.component';
import { AddAssetComponent } from './add-asset/add-asset.component';
import { UpdateComponent } from './update/update.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { RemoveCanComponent } from './remove-can/remove-can.component';
import { CandListComponent } from './cand-list/cand-list.component';
import { AppatListComponent } from './appat-list/appat-list.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ManagerComponent } from './manager/manager.component';
import { RemoveAssComponent } from './remove-ass/remove-ass.component';
import { FlatListComponent } from './flat-list/flat-list.component';
import { RequestsComponent } from './requests/requests.component';
import { UserSeeReqComponent } from './user-see-req/user-see-req.component';


const routes: Routes = [
  { path: `login`, component: AdminLoginComponent },
  { path: `register`, component: RegisterComponent },
  {
    path: `admin`, component: AdminComponent,
    canActivate: [AuthGuardService], data: { roles: ['admin'] }
  },
  {
    path: `user`, component: UserComponent,
    canActivate: [AuthGuardService], data: { roles: ['user'] }
  },
  {path : `addasset`, component: AddAssetComponent},
  {path : `updateasset`, component: UpdateComponent},
  {path : `empadd`, component: AddEmpComponent},
  {path : `removecan`, component : RemoveCanComponent},
  {path : `canlist`, component : CandListComponent},
  {path : `appartlist`, component : AppatListComponent},
  {path : `view`, component : HomePageComponent},
  {path : `manager`, component : ManagerComponent},
  {path : `removeass`, component: RemoveAssComponent},
  {path : `flatlist`, component: FlatListComponent},
  {path : `req`, component: RequestsComponent},
  {path: `seereq`, component: UserSeeReqComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
