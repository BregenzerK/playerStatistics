import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {PlayerListComponent} from "./player-list/player-list.component";
import {PlayerDetailComponent} from "./player-detail/player-detail.component";
import {PlayerListResolver} from "./resolver/player-list-resolver.service";
import {PlayerResolver} from "./resolver/player-resolver.service";

const routes: Routes = [
  {path: '', component: PlayerListComponent, resolve: {playerList: PlayerListResolver}},
  {path: 'player/:id', component: PlayerDetailComponent, resolve:{player: PlayerResolver}},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

