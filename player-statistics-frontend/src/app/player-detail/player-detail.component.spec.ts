import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PlayerDetailComponent} from './player-detail.component';
import {CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {PLAYER_LIST_MOCK} from "../../mock/player-list.mock";
import {RouterStub} from "../../mock/router.stub";

describe('PlayerDetailComponent', () => {
  let component: PlayerDetailComponent;
  let fixture: ComponentFixture<PlayerDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerDetailComponent ],
      schemas:[CUSTOM_ELEMENTS_SCHEMA],
      providers: [
        {
          provide: ActivatedRoute, useValue: {
            data: Observable.of({
              player: PLAYER_LIST_MOCK[0],
            })
          },
        },
        {provide: Router, useClass: RouterStub},
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
