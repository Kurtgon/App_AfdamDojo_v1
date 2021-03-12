import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../../Interfaces/user'

import {AutenticadorJwtService} from '../../services/autenticador-jwt.service';
import { UserloginService } from 'src/app/services/userlogin.service';

import Swal from 'sweetalert2';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  submitted = false;

  onSubmit() { this.submitted = true; }

  user: User = null;
  //Inyectamos los servicios que vamos a necesitar para autenticar al usuario cuando nos logueamos
  constructor(private userlogin: UserloginService, private jwt: AutenticadorJwtService, private router: Router) { }

  ngOnInit(): void {

    this.user = {
      username: "",
      password: ""
    }

  }

  autenticarUser(){
    //Nos aseguramos que no hay usuarios logeados limpiando el localstore
    this.userlogin.cerrarSesion();

    this.userlogin.iniciarSesion(this.user).subscribe((res)=>{
      //Sistema de alertar y controlar errores
      Swal.fire({
        title: `${this.user.username}`, 
        text: 'Bienvenido al Dojo',
        icon: 'success',
      })
      this.jwt.almacenaJWT(res);
      this.jwt.almacenaUser(this.user);
      this.router.navigate(['/userlogin']);
    },
    (error) => {
      Swal.fire({
        title: `Error al realizar el login`,
        text: 'El usuario o el password no es correcto',
        icon: 'error'
      })
    })
  }
}
