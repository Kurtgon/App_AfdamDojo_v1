import { Component, OnInit } from '@angular/core';
import { UserloginService } from 'src/app/services/userlogin.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  constructor(public userLoginService: UserloginService) { }

  ngOnInit(): void {
  }

}
