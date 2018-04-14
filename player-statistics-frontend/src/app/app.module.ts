import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {PlayerListComponent} from './player-list/player-list.component';
import {PlayerDetailComponent} from './player-detail/player-detail.component';
import {AppRoutingModule} from './app-routing.module';
import {PlayerListResolver} from "./resolver/player-resolver.service";
import {StatisticsControllerService} from "../generated";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent,
    PlayerListComponent,
    PlayerDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [PlayerListResolver,
    StatisticsControllerService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
