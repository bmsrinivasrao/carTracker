import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {VehicleService} from './services/vehicle/vehicle.service';
import {ReadingsService} from './services/readings/readings.service';
import { VehiclesListComponent } from './components/vehicles-list/vehicles-list.component';
import { VehiclesHistoryComponent } from './components/vehicles-history/vehicles-history.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpModule} from '@angular/http';
import { OrderModule } from 'ngx-order-pipe';


const appRoutes: Routes = [
  { path: 'vehicles', component: VehiclesListComponent },
  { path: 'vehicles/:id', component: VehiclesHistoryComponent },
  { path: '', redirectTo: '/vehicles', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    VehiclesListComponent,
    VehiclesHistoryComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    OrderModule
  ],
  providers: [VehicleService, ReadingsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
