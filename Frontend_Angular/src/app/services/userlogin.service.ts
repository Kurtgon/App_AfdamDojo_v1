import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { User } from '../Interfaces/user';
import {Router} from '@angular/router';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class UserloginService {

  userLogin : User=null;
  
  constructor(private http: HttpClient, private router:Router) { }

  //Para utilizar el activeCam
  public statusUsuarioLog = new Subject<boolean>();
  public losStatus$ = this.statusUsuarioLog.asObservable();
  public url = "";



  iniciarSesion(userInicio: User) : Observable<any>{
   this.userLogin = userInicio;
    
    return this.http.post(environment.loginUrl, this.userLogin, {responseType: 'text'} );
  }

  cerrarSesion(){
    //borramos todos los datos del localstore
    localStorage.clear();
    this.router.navigate(['/index']);
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
