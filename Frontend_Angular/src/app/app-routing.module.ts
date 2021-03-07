import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistroComponent } from 'Testeo/src/app/components/registro/registro.component';
import { LoginComponent } from './components/login/login.component';
import { InicioLoginRegistroComponent } from './inicio-login-registro/inicio-login-registro.component';
import { UserloginComponent } from './components/userlogin/userlogin.component'
import { IsLogedGuard } from './guards/is-loged.guard';

const routes: Routes = [

  {path:'index', component:InicioLoginRegistroComponent},
  {path:'login', component:LoginComponent},
  {path:'signin', component:RegistroComponent},
  {path:'userlogin', component:UserloginComponent, canActivate: [IsLogedGuard]},
  {path:'**', pathMatch:'full', redirectTo:'index'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
