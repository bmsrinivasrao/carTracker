import {Component, OnInit} from '@angular/core';
import {ReadingsService} from '../../services/readings/readings.service';
import {VehicleService} from '../../services/vehicle/vehicle.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-vehicles-history',
  templateUrl: './vehicles-history.component.html',
  styleUrls: ['./vehicles-history.component.css']
})
export class VehiclesHistoryComponent implements OnInit {
  vehicleData;
  readingsData;
  vinNum;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService, private readingService: ReadingsService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => this.vinNum = params['id']);
    this.vehicleService.getOneVehicle(this.vinNum)
      .subscribe(
        vehicles => this.vehicleData = vehicles,
        error => console.log(error)
      );
    this.readingService.getReadings(this.vinNum)
      .subscribe(
        vehicles => this.readingsData = vehicles,
        error => console.log(error)
      );
  }

}
