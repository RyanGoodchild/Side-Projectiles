package com.techelevator.controller;

import com.techelevator.dao.PotholeDao;
import com.techelevator.model.Coords;
import com.techelevator.model.Pothole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@CrossOrigin
public class PotholeController {

    @Autowired
    PotholeDao potholeDao;

    @RequestMapping(path = "/coords", method = RequestMethod.GET)
    public List<Coords> getAllCoords() {
        return potholeDao.getAllCoords();
    }

    @RequestMapping(path = "/potholes", method = RequestMethod.GET)
    public List<Pothole> listPotholes(){
        return potholeDao.getAllPotholes();
    }

    @RequestMapping(path = "/potholes/{id}", method = RequestMethod.GET)
    public Pothole getPotholeById(@PathVariable long id){

        return potholeDao.getPotholeById(id);
    }

    @RequestMapping(path = "/report", method = RequestMethod.POST)
    public void reportPothole(@RequestBody Pothole pothole){

        potholeDao.reportPothole(pothole);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public void updatePothole(@RequestBody Pothole updatePothole,@PathVariable long id){
        potholeDao.updatePothole(updatePothole, id);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePothole(Pothole deletePothole, @PathVariable long id){
        potholeDao.deletePothole(deletePothole, id);
    }

}
