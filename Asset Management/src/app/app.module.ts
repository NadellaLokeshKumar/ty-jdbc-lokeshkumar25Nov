import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddAssetComponent } from './add-asset/add-asset.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateComponent } from './update/update.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { HomeComponent } from './home/home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { RemoveCanComponent } from './remove-can/remove-can.component';
import { CandListComponent } from './cand-list/cand-list.component';
import { AppatListComponent } from './appat-list/appat-list.component';
import { ManagerComponent } from './manager/manager.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RemoveAssComponent } from './remove-ass/remove-ass.component';
import { FlatListComponent } from './flat-list/flat-list.component';
import { RequestsComponent } from './requests/requests.component';
import { UserSeeReqComponent } from './user-see-req/user-see-req.component';

@NgModule({
  declarations: [
    AppComponent,
    AddAssetComponent,
    UpdateComponent,
    AddEmpComponent,
    HomeComponent,
    AdminLoginComponent,
    RegisterComponent,
    AdminComponent,
    UserComponent,
    RemoveCanComponent,
    CandListComponent,
    AppatListComponent,
    ManagerComponent,
    HomePageComponent,
    RemoveAssComponent,
    FlatListComponent,
    RequestsComponent,
    UserSeeReqComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
