import {TestBed} from '@angular/core/testing';

import {PlayerListResolver} from './player-list-resolver.service';
import {CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {StatisticsControllerServiceMock} from "../../mock/statisticsController.service.mock";

describe('PlayerListResolver', () => {
  let playerListResolver: PlayerListResolver;

  const statisticsService = new StatisticsControllerServiceMock(null, '', null);

  beforeEach(() => {
    TestBed.configureTestingModule({
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
      providers: [PlayerListResolver]
    });
    playerListResolver = new PlayerListResolver(statisticsService);
  });

  it('should be created', () => {
    expect(playerListResolver).toBeTruthy();
  });
});
