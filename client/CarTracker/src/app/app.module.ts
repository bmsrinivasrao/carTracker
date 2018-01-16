import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import {VehicleService} from './services/vehicle/vehicle.service';
import {ReadingsService} from './services/readings/readings.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [VehicleService, ReadingsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
