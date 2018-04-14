import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {AppComponent} from './app.component';
import {PlayerListComponent} from './player-list/player-list.component';
import {PlayerDetailComponent} from './player-detail/player-detail.component';
import {AppRoutingModule} from './app-routing.module';
import {PlayerListResolver} from "./resolver/player-list-resolver.service";
import {StatisticsControllerService} from "../generated";
import {HttpClientModule} from "@angular/common/http";
import {PlayerResolver} from "./resolver/player-resolver.service";


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
    MDBBootstrapModule.forRoot()
  ],
  providers: [
    PlayerListResolver,
    PlayerResolver,
    StatisticsControllerService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
