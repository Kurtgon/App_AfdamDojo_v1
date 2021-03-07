import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../Interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {

  constructor(private http: HttpClient) { }

  postRegistro(user: User):Observable<any>{
    return this.http.post<User>('http://localhost:8080/user/sign-up', user); 
   }
}
