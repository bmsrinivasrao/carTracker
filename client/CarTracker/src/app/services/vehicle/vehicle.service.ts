import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Http} from '@angular/http';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable()
export class VehicleService {
  constructor(private http: Http) {}

  getVehicle(): Observable<any[]> {
   return this.http.get('http://localhost:8080/api/vehicles')
              .map(response => response.json())
              .catch(error => Observable.throw(error.statusText));
  }
}
