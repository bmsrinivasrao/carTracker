import {Component, OnInit} from '@angular/core';
import {ReadingsService} from '../../services/readings/readings.service';
import {VehicleService} from '../../services/vehicle/vehicle.service';

@Component({
  selector: 'app-vehicles-list',
  templateUrl: './vehicles-list.component.html',
  styleUrls: ['./vehicles-list.component.css']
})
export class VehiclesListComponent implements OnInit {
  vehiclesData = [];
  readingsData = [];
  vinNum: string;

  setReadings(val) {
    this.vinNum = val;
  }

  constructor(vehicleService: VehicleService, readingService: ReadingsService) {
    vehicleService.getVehicle()
      .subscribe(
        vehicles => this.vehiclesData = vehicles,
        error => console.log(error)
      );
    readingService.getReadings(this.vinNum)
      .subscribe(
        readings => this.readingsData = readings,
        error => console.log(error)
      );
  }

  ngOnInit() {
  }

}
