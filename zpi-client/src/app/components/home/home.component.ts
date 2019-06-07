import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { SessionService } from '../../services/session.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _router: Router, private sessioService: SessionService) { }

  selectedRoute;
  data:Array<Object> = [
    { id: 0, name: "---", link: "" },
    { id: 1, name: "Ilość sesji wzrostowych, spadkowych i bez zmian", link: "/sessions" },
    { id: 2, name: "Miary statystyczne", link: "/statistical-data" },
    { id: 3, name: "Rozkład zmian miesięcznych i kwartalnych", link: "/currency-decay" }
  ]

  selected() {
    console.log(this.selectedRoute.link);
  }

  showAnalysis() {
    this._router.navigate([this.selectedRoute.link]);
  }

  ngOnInit() {
  }

}
