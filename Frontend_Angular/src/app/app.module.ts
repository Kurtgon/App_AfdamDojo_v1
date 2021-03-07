import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistroComponent } from './components/registro/registro.component';

import { InicioLoginRegistroComponent } from './inicio-login-registro/inicio-login-registro.component';
import { LoginComponent } from './components/login/login.component';
import { NavComponent } from './components/barra-nav/nav/nav.component';
import { HttpClientModule } from '@angular/common/http';
import { UserloginComponent } from './components/userlogin/userlogin.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistroComponent,
    
    InicioLoginRegistroComponent,
    
    LoginComponent,
    
    NavComponent,
    
    UserloginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
