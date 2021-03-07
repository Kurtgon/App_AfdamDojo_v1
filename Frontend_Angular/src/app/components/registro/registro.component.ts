import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Registro } from 'src/app/Interfaces/registro';
import { AlumnoService } from 'src/app/services/alumno.service';
import { DisciplinaService } from 'src/app/services/disciplina.service';
import { Router } from '@angular/router';
import { Disciplina } from 'src/app/Interfaces/disciplina';


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss']
})
export class RegistroComponent implements OnInit {

  // Propiedades de la clase
  loginForm: FormGroup; // Permite tener un objeto linkado a los campos del formulario de autenticación
  ocultarPassword: boolean = true; // Utilizado para conocer si se muestra o se oculta el contenido del campo password
  disciplinas: Disciplina[];
  disciplinas2: string [];

  registro: Registro;

  constructor(private disciplinaService: DisciplinaService, private alumnoService: AlumnoService, private router:Router) { }

  ngOnInit(): void {
  
    this.cargarDisciplinas();


    this.loginForm = new FormGroup({
      usuario: new FormControl('gonzalo', [Validators.required, Validators.minLength(4)]),
      password: new FormControl('12345', [Validators.required, Validators.minLength(4)]),
      email: new FormControl('', [Validators.required, Validators.minLength(4)]),
      dni: new FormControl('', [Validators.required, Validators.minLength(8)]),
      name: new FormControl('',[]),
      surnames: new FormControl('',[]),
      tlf: new FormControl('',[]),
      birthdate: new FormControl('',[]),
      contact: new FormControl('',[]),
      allergy: new FormControl('',[]),
      disciplinas: new FormControl('',[])
    })
  }

  enviar(){
    this.registro = {
      username: this.loginForm.value.usuario,
      password: this.loginForm.value.password,
      email: this.loginForm.value.email,
      name: this.loginForm.value.dni,
      surnames: this.loginForm.value.surnames,
      dni: this.loginForm.value.dni,
      tfl: this.loginForm.value.tlf,
      address: this.loginForm.value.address,
      birthdate: this.loginForm.value.birthdate,
      contact: this.loginForm.value.contact,
      allergy: this.loginForm.value.allergy,
      disciplinas: this.loginForm.value.disciplinas
    }
    this.alumnoService.postRegistro(this.registro).subscribe((res:any)=>{
      this.router.navigate(['/login']);
    });
  }

  cargarDisciplinas(){
    this.disciplinas = [];
    this.disciplinaService.getListaDisciplinas().subscribe((res)=>{
      console.log(res);
     res.forEach(element => {
        this.disciplinas.push(element);
     });
    })
  }


}
