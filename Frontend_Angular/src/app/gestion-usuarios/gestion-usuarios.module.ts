import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GestionUsuariosRoutingModule } from './gestion-usuarios-routing.module';
import { FormsModule } from '@angular/forms';
import { GestionUsuariosComponent } from './gestion-usuarios.component';
import { UpPassComponent } from './components/up-pass/up-pass.component';
import { UpMisDatosComponent } from './components/up-mis-datos/up-mis-datos.component';


@NgModule({
  declarations: [GestionUsuariosComponent, UpPassComponent, UpMisDatosComponent],
  imports: [
    CommonModule,
    GestionUsuariosRoutingModule,
    FormsModule
  ]
})
export class GestionUsuariosModule { }
