import {Component, OnInit} from '@angular/core';
import {ReadingsService} from '../../services/readings/readings.service';
import {VehicleService} from '../../services/vehicle/vehicle.service';

@Component({
  selector: 'app-vehicles-history',
  templateUrl: './vehicles-history.component.html',
  styleUrls: ['./vehicles-history.component.css']
})
export class VehiclesHistoryComponent implements OnInit {
  constructor(vehicleService: VehicleService, readingService: ReadingsService) {
  }


  ngOnInit() {
  }

}
