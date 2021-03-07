import { Injectable } from '@angular/core';
import { User } from '../Interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class AutenticadorJwtService {

  constructor() { }

  /**
   * Permite guardar el jwt(token) recibido
   * @Param token
   */

  // Guardo el JWT recibido del servidor en el almacenamiento local 
  almacenaJWT(token: string) {
    //Guardamos el jwt en local
    localStorage.setItem("jwt", token);
  }

  //Recuperar el token (jwt)
  recuperarJWT(): string {
    return localStorage.getItem("jwt");
  }

  //Eliminar el token (jwt)
  eliminarJWT() {
    localStorage.removeItem("jwt");
  }

  //Guardo el user recibido del servidor
  almacenaUser(user: User){
    localStorage.setItem("user", JSON.stringify(user));
  }

  //Recuperar el user
  recuperarUser(): User {
    return JSON.parse(localStorage.getItem("user"));
  }

  //Eliminar el user
  eliminarUser() {
    localStorage.removeItem("user");
  }
}
