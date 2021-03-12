import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Disciplina } from '../Interfaces/disciplina';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DisciplinaService {

  
  
   endpoint: string = environment.endpointDisciplinas;

   //Inyectamos en el construtor el http para el endpoint
  constructor(private http: HttpClient) {

   }
  
   //Nos traemos el get de disciplinas desde el backend
   getListaDisciplinas(): Observable<Disciplina[]>{
    return this.http.get<Disciplina[]>(this.endpoint);
  }

}
