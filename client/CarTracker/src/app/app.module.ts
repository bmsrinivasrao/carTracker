import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {VehicleService} from './services/vehicle/vehicle.service';
import {ReadingsService} from './services/readings/readings.service';
import { VehiclesListComponent } from './components/vehicles-list/vehicles-list.component';
import { VehiclesHistoryComponent } from './components/vehicles-history/vehicles-history.component';
import {HttpModule} from '@angular/http';


@NgModule({
  declarations: [
    AppComponent,
    VehiclesListComponent,
    VehiclesHistoryComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [VehicleService, ReadingsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
