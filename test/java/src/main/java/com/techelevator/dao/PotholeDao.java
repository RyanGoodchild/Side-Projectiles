package com.techelevator.dao;

import com.techelevator.model.Coords;
import com.techelevator.model.Pothole;

import java.util.List;

public interface PotholeDao {

    public List<Coords> getAllCoords();
    public List<Pothole> getAllPotholes();
    public Pothole getPotholeById(long id);
    public void updatePothole(Pothole updatePothole, long id);
    public void reportPothole(Pothole pothole);
    public void deletePothole(Pothole deletePothole, long id);

}
