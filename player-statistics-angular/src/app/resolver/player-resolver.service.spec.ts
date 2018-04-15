import {TestBed} from '@angular/core/testing';

import {PlayerResolver} from './player-resolver.service';
import {StatisticsControllerServiceMock} from "../../mock/statisticsController.service.mock";

describe('PlayerResolverService', () => {
  let playerResolver: PlayerResolver;

  const statisticsService = new StatisticsControllerServiceMock(null, '', null);

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PlayerResolver]
    });
    playerResolver = new PlayerResolver(statisticsService);
  });

  it('should be created', () => {
    expect(playerResolver).toBeTruthy();
  });
});
