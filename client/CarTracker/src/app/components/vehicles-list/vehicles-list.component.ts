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
  PORSCHECAYENNE = 'http://www.shopswindows.com/wp-content/uploads/2014/10/2015-porsche-cayenne-turbo-front-view.jpg';
  BMW528 = 'https://pictures.topspeed.com/IMG/crop/201004/2011-bmw-528i-sedan-1_1600x0w.jpg';
  AUDIQ7 = 'https://www.cstatic-images.com/stock/900x600/258995.jpg';
  HONDACRV = 'http://shop.honda.com/images/2018/cr-v/shop/gallery/1386x780_06.jpg';
  CHEVROLETSILVERADO = 'https://blog.caranddriver.com/wp-content/uploads/2016/04/2016-Chevrolet-Silverado-Rally-Realtree-Editions-PLACEMENT.jpg';
  TOYOTACOROLLA = 'https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/CAC30TOC041A021001.jpg';
  FORDMUSTANG = 'http://st.motortrend.com/uploads/sites/10/2015/11/2010-ford-mustang-gt-premium-coupe-angular-front.png';
  VOLKSWAGENPASSAT = 'http://www.arabgt.com/sites/default/files/fwlks-wgn-bst-2012_002_0.jpg';
  HONDAACCORD = 'https://media.ed.edmunds-media.com/honda/accord/2015/oem/2015_honda_accord_sedan_sport_fq_oem_1_1280.jpg';
  FORDESCAPE = 'https://upload.wikimedia.org/wikipedia/commons/4/4c/1st_Ford_Explorer_Sport_Trac_--_03-21-2012.JPG';

  carURL(vinNum) {
    if (vinNum === 'WP1AB29P63LA60179') {
      return this.PORSCHECAYENNE;
    }
    if (vinNum === 'WBAFR1C50BC747531') {
      return this.BMW528;
    }
    if (vinNum === 'WA1CMAFE6BD002500') {
      return this.AUDIQ7;
    }
    if (vinNum === '5J6RM3H50DL032829') {
      return this.HONDACRV;
    }
    if (vinNum === '3GCRKSE30AG105585') {
      return this.CHEVROLETSILVERADO;
    }
    if (vinNum === '2T1BU4EE4DC919097') {
      return this.TOYOTACOROLLA;
    }
    if (vinNum === '1ZVBP8JS8A5159269') {
      return this.FORDMUSTANG;
    }
    if (vinNum === '1VWAP7A35CC020276') {
      return this.VOLKSWAGENPASSAT;
    }
    if (vinNum === '1HGCR2F3XFA027534') {
      return this.HONDAACCORD;
    }
    if (vinNum === '1FMYU02143KB34432') {
      return this.FORDESCAPE;
    }
  }

  constructor(private vehicleService: VehicleService) {
  }

  ngOnInit() {
    this.vehicleService.getVehicle()
      .subscribe(
        vehicles => this.vehiclesData = vehicles,
        error => console.log(error)
      );
  }
}
