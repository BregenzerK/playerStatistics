import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Player, StatisticsControllerService} from "../../generated";
import {Observable} from "rxjs/Observable";

@Injectable()
export class PlayerListResolver implements Resolve<Player[]>{

  constructor(private statisticService: StatisticsControllerService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Player[]> {
    return this.statisticService.getAllPlayersUsingGET();
  }

}
