import { TestBed, inject } from '@angular/core/testing';

import { PlayerListResolver } from './player-resolver.service';

describe('PlayerListResolver', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PlayerListResolver]
    });
  });

  it('should be created', inject([PlayerListResolver], (service: PlayerListResolver) => {
    expect(service).toBeTruthy();
  }));
});
