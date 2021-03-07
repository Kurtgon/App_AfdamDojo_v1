import { Component, OnInit } from '@angular/core';

import { User } from '../../Interfaces/user'
import { Router } from '@angular/router';
import {AutenticadorJwtService} from '../../services/autenticador-jwt.service';
import { UserloginComponent } from '../userlogin/userlogin.component';
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

  constructor(private userlogin: UserloginService, private jwt: AutenticadorJwtService, private router: Router) { }

  ngOnInit(): void {

    this.user = {
      username: " ",
      password: " "
    }

  }

  autenticarUser(){
    //Nos aseguramos que no hay usuarios logeados limpiando el localstore
    this.userlogin.cerrarSesion();

    this.userlogin.iniciarSesion(this.user.username, this.user.password).subscribe((res)=>{
      Swal.fire({
        title: `${this.user.username}`, 
        text: 'Logeado',
        icon: 'success',
      })
      this.jwt.almacenaJWT(res);
      this.router.navigate(['/userlogin']);
    },
    (error) => {
      console.log(error)
      Swal.fire({
        title: `${error.error}`,
        text: 'Error, Jwt no almacenado correctamente',
        icon: 'error'
      })
    })
  }
}
