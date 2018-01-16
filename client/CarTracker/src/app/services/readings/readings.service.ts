import {Injectable} from '@angular/core';

@Injectable()
export class ReadingsService {

  readsData = [
    {
      'vin': 'WP1AB29P63LA60179',
      'make': 'PORSCHE',
      'model': 'CAYENNE',
      'year': 2015,
      'redlineRpm': 6700,
      'maxFuelVolume': 26,
      'lastServiceDate': '2017-12-20T18:20:09.267Z'
    },
    {
      'vin': 'WBAFR1C50BC747531',
      'make': 'BMW',
      'model': '528',
      'year': 2011,
      'redlineRpm': 7000,
      'maxFuelVolume': 18,
      'lastServiceDate': '2017-01-23T18:39:11.329Z'
    },
    {
      'vin': 'WA1CMAFE6BD002500',
      'make': 'AUDI',
      'model': 'Q7',
      'year': 2011,
      'redlineRpm': 4750,
      'maxFuelVolume': 22,
      'lastServiceDate': '2017-04-21T06:26:30.367Z'
    },
    {
      'vin': '5J6RM3H50DL032829',
      'make': 'HONDA',
      'model': 'CR-V',
      'year': 2013,
      'redlineRpm': 6400,
      'maxFuelVolume': 14,
      'lastServiceDate': '2017-05-15T12:14:37.687Z'
    },
    {
      'vin': '3GCRKSE30AG105585',
      'make': 'CHEVROLET',
      'model': 'SILVERADO',
      'year': 2010,
      'redlineRpm': 6000,
      'maxFuelVolume': 26,
      'lastServiceDate': '2017-03-25T11:32:12.018Z'
    },
    {
      'vin': '2T1BU4EE4DC919097',
      'make': 'TOYOTA',
      'model': 'COROLLA',
      'year': 2013,
      'redlineRpm': 6500,
      'maxFuelVolume': 13,
      'lastServiceDate': '2017-01-14T05:39:09.258Z'
    },
    {
      'vin': '1ZVBP8JS8A5159269',
      'make': 'FORD',
      'model': 'MUSTANG',
      'year': 2010,
      'redlineRpm': 8200,
      'maxFuelVolume': 16,
      'lastServiceDate': '2017-05-14T04:04:49.883Z'
    },
    {
      'vin': '1VWAP7A35CC020276',
      'make': 'VOLKSWAGEN',
      'model': 'PASSAT',
      'year': 2012,
      'redlineRpm': 6200,
      'maxFuelVolume': 18,
      'lastServiceDate': '2017-06-26T01:29:20.645Z'
    },
    {
      'vin': '1HGCR2F3XFA027534',
      'make': 'HONDA',
      'model': 'ACCORD',
      'year': 2015,
      'redlineRpm': 6000,
      'maxFuelVolume': 17,
      'lastServiceDate': '2017-03-14T18:18:01.920Z'
    },
    {
      'vin': '1FMYU02143KB34432',
      'make': 'FORD',
      'model': 'ESCAPE',
      'year': 2003,
      'redlineRpm': 6500,
      'maxFuelVolume': 15,
      'lastServiceDate': '2017-01-12T04:24:24.464Z'
    }
  ];

  constructor() {
  }

  getReadings() {
    return this.readsData;
  }

}
