import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { User } from '../Interfaces/user';
import {Router} from '@angular/router';
import { exit } from 'node:process';


@Injectable({
  providedIn: 'root'
})
export class UserloginService {

  constructor(private http: HttpClient, router:Router) { }

  
  public statusUsuarioLog = new Subject<boolean>();
  public losStatus$ = this.statusUsuarioLog.asObservable();
  public url = "";

  iniciarSesion(username:string, password:string) : Observable<any>{
    let userLogin : User = {
      username: username,
      password: password
    };
    console.log("exito")
    return this.http.post('http://localhost:8080/user/login', userLogin, {responseType: 'text'} );
  }

  cerrarSesion(){
    //borramos todos los datos del localstore
    localStorage.clear();
  }

  modificarContraseña(nuevaPassword:string) : Observable<object>{
    let dto = {
      'password': nuevaPassword
    };
    return this.http.post<object>('/modificarPassword/', dto);
  }

  isLoggedIn(url: string){
    const isLogged = localStorage.getItem('jwt');

    if(!isLogged){
      this.url = url;
      return false;
    }
    return true;
  }
}
