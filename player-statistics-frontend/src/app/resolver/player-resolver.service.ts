import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Player, StatisticsControllerService} from "../../generated";
import {Observable} from "rxjs/Observable";

@Injectable()
export class PlayerResolver implements Resolve<Player>{

  constructor(private statisticsService: StatisticsControllerService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Player> {
    return this.statisticsService.getPlayerUsingGET(route.params.id);
  }

}
