import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Disciplina } from '../Interfaces/disciplina';

@Injectable({
  providedIn: 'root'
})
export class DisciplinaService {

  

   endpoint: string = 'http://localhost:8080/disciplinas';

  constructor(private http: HttpClient) {

   }
  
   getListaDisciplinas(): Observable<Disciplina[]>{
    return this.http.get<Disciplina[]>(this.endpoint);
  }

}
