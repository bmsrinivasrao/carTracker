package io.egen.controller;

import io.egen.entity.Alert;
import io.egen.entity.AlertsBulk;
import io.egen.entity.Reading;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
public class ReadingCtrl {

    @Autowired
    ReadingService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading findOne(@PathVariable("vin") String vin) {
        return service.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/alerts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AlertsBulk> findAllAlerts() {
        return service.findAllAlerts();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading reads, Alert alert, AlertsBulk alertsBulk) {
        return service.create(reads, alert, alertsBulk);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/{vin}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading update(@PathVariable("vin") String vin, @RequestBody Reading reads, Alert alert, AlertsBulk alertsBulk) {
        return service.update(vin, reads, alert, alertsBulk);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    @ResponseBody
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }
}
