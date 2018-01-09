package io.egen.controller;

import io.egen.service.VehicleService;
import io.egen.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleCtrl {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vin) {
        return service.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Vehicle veh) {
        return service.create(veh);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{vin}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("vin") String vin, @RequestBody Vehicle veh) {
        return service.update(vin, veh);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    @ResponseBody
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }
}
