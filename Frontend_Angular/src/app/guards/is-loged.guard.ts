import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { UserloginService } from '../services/userlogin.service';


@Injectable({
  providedIn: 'root'
})
export class IsLogedGuard implements CanActivate {

  // constructor con las inyecciones
  constructor(private userLoginService: UserloginService, private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> {
    // verifica si está logeado preguntando al servicio saca la url que está apuntando
    if (this.userLoginService.isLoggedIn(state.url)) {
      return true;
    }

    // sino mostramos una alerta de error informando que no está logeado
    
Swal.fire ({
      title: 'No has iniciado sesión',
      text: 'Para acceder a la página tienes que iniciar la sesión',
      icon: 'error',
    });
    
    // redireciono al login
    this.router.navigate(['login']);

    return false;
  }
  
}
