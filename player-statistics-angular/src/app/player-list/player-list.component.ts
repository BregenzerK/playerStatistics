import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import 'rxjs/add/operator/map';
import {Player} from "../../generated";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.scss']
})
export class PlayerListComponent implements OnInit {
  playerList: Observable<Player[]>;

  constructor(private activeRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.playerList = this.activeRoute.data.map((data) => data.playerList);
  }

  public navigateTo(playerId:number){
    this.router.navigate([`/player/${playerId}`])
  }

}
