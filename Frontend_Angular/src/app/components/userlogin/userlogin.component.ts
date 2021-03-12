import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Interfaces/user';
import { UserloginService } from 'src/app/services/userlogin.service';
import {AutenticadorJwtService} from '../../services/autenticador-jwt.service'

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.scss']
})
export class UserloginComponent implements OnInit {

  username: User;
  disciplina:string;

  constructor(private autenticador: AutenticadorJwtService, public userLoginService: UserloginService) { }

  ngOnInit(): void {
    this.username=this.autenticador.recuperarUser();
   
  }


}
