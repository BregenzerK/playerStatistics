import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Player} from "../../generated";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-player-detail',
  templateUrl: './player-detail.component.html',
  styleUrls: ['./player-detail.component.scss']
})
export class PlayerDetailComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  player: Observable<Player>;

  ngOnInit() {
    this.player = this.activatedRoute.data.map((data) => data.player);
  }

  public goBack(): void {
    this.router.navigate(['/']);
  }

}
