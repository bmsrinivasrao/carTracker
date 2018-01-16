import {Component} from '@angular/core';
import {VehicleService} from './services/vehicle/vehicle.service';
import {ReadingsService} from './services/readings/readings.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  vehiclesData = [];
  readingsData = [];
  highalerts: string;
  mediumaletrs: number;
  lowaletrs: number;

  constructor(vehicleService: VehicleService, readingService: ReadingsService) {
    this.vehiclesData = vehicleService.getVehicle();
    this.readingsData = readingService.getReadings();
  }

  detailsClick(val) {
  }
}
