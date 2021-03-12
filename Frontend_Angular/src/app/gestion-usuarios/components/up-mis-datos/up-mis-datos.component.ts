import { Component, OnInit } from '@angular/core';
import { Alumno } from 'src/app/Interfaces/alumno';
import { GestionUsuariosService } from '../../services/gestion-usuarios.service';
import Swal from 'sweetalert2';
import { Disciplina } from 'src/app/Interfaces/disciplina';
import { DisciplinaService } from 'src/app/services/disciplina.service';

@Component({
  selector: 'app-up-mis-datos',
  templateUrl: './up-mis-datos.component.html',
  styleUrls: ['./up-mis-datos.component.scss']
})
export class UpMisDatosComponent implements OnInit {

  alumno: Alumno = {
    name: "",
    surnames: "",
    dni:"",
    tfl:"",
    address:"",
    birthdate:"",
    contact:"",
    allergy:"",
    disciplinas:""
  }

  disciplinas: Disciplina[];

  constructor(private gestion:GestionUsuariosService, private disciplinaService: DisciplinaService) { }

  ngOnInit(): void {
    this.cargarDisciplinas();
  }

  actualizarMisDatos(){
    this.gestion.modificarMisDatos( this.alumno ).subscribe(( res ) => {
      Swal.fire({
        title: 'Modificación de datos',
        text: 'Se ha actualizado los datos',
        icon: 'success',
      })
    },(error)=>{
      Swal.fire({
        title: 'Error al actualizar los campos',
        text: 'No se ha podido actualizar los campos',
        icon: 'error'
      })
    })
  }

  cargarDisciplinas(){
    this.disciplinas = [];
    this.disciplinaService.getListaDisciplinas().subscribe((res)=>{
     res.forEach(element => {
        this.disciplinas.push(element);
     });
    })
  }

}
