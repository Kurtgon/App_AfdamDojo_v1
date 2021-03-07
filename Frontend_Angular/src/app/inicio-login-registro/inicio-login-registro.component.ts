import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio-login-registro',
  templateUrl: './inicio-login-registro.component.html',
  styleUrls: ['./inicio-login-registro.component.scss']
})
export class InicioLoginRegistroComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


}
