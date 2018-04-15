import {StatisticsControllerService} from "../generated";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/of';
import {PLAYER_LIST_MOCK} from "./player-list.mock";

export class StatisticsControllerServiceMock extends StatisticsControllerService{

  public getAllPlayersUsingGET(observe: any = 'body', reportProgress: boolean = false ): Observable<any> {
    return Observable.of(PLAYER_LIST_MOCK);
  }

  public getPlayerUsingGET(id: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {
    return Observable.of(PLAYER_LIST_MOCK[0]);
  }
}
