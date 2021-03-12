import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/Interfaces/user';
import { AutenticadorJwtService } from 'src/app/services/autenticador-jwt.service';

import Swal from 'sweetalert2';
import { GestionUsuariosService } from '../../services/gestion-usuarios.service';

@Component({
  selector: 'app-up-pass',
  templateUrl: './up-pass.component.html',
  styleUrls: ['./up-pass.component.scss']
})
export class UpPassComponent implements OnInit {

  submitted = false;

  onSubmit() { this.submitted = true;}

  actualPassword: string;
  newPassword: string;
  confirmPassword: string;
  

  constructor(private autenticador: AutenticadorJwtService, private gestion: GestionUsuariosService, private router: Router) { }

  ngOnInit(): void {
  }

  //Método para actualizar el password
  upPassword(){
    if(this.autenticador.recuperarUser().password === this.actualPassword){
      this.gestion.modificarPassword(this.newPassword).subscribe((res:User)=>{
        Swal.fire({
          title: `${res.username}`,
          text: 'Se ha actualizado la contraseña',
          icon: 'success',
        })
        this.autenticador.almacenaUser(res);
        this.router.navigate(['/userlogin']);
      },
      (error) => {
        Swal.fire({
          title: 'Error en la contraseña',
          text: 'La contraseña no se ha actualizado correctamente',
          icon: 'error'
        })
      })
    }

  }

  validarPassword(){
    if(this.newPassword === this.confirmPassword){
      return true;
    }
     return false;
  }

}
