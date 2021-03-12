import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpMisDatosComponent } from './components/up-mis-datos/up-mis-datos.component';
import { UpPassComponent } from './components/up-pass/up-pass.component';

import { GestionUsuariosComponent } from './gestion-usuarios.component';
import { IsLogedGuard } from '../guards/is-loged.guard';

const routes: Routes = [{ path: '', component: GestionUsuariosComponent },
{ path: 'misdatos', component: UpMisDatosComponent, canActivate: [IsLogedGuard]},
{ path: 'uppass', component: UpPassComponent, canActivate: [IsLogedGuard]},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GestionUsuariosRoutingModule { }
