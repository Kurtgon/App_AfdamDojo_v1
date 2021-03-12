import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alumno } from 'src/app/Interfaces/alumno';
import { User } from 'src/app/Interfaces/user';
import { AutenticadorJwtService } from 'src/app/services/autenticador-jwt.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GestionUsuariosService {

  user: User;

  constructor(private autenticador: AutenticadorJwtService, private http: HttpClient) { }


  modificarPassword( newPassword: string ){
    this.user = {
      username: this.autenticador.recuperarUser().username,
      password: newPassword
    }
    return this.http.put(environment.upPassword, this.user);
  }

  modificarMisDatos( alumno: Alumno){
    return this.http.put(environment.upMisDatos, alumno);
  }
}
