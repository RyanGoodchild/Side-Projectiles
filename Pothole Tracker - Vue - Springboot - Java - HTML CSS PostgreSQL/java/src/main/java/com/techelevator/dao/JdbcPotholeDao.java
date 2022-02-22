package com.techelevator.dao;

import com.techelevator.model.Coords;
import com.techelevator.model.Pothole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPotholeDao implements PotholeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPotholeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Coords> getAllCoords() {
        List<Coords> coordinates = new ArrayList<>();
        String sql = "SELECT pothole_id, latitude, longitude FROM potholes";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Coords coords = mapRowToCoordinate(results);
            coordinates.add(coords);
        }
        return coordinates;

    }

    @Override
    public List<Pothole> getAllPotholes() {
        List<Pothole> potholes = new ArrayList<>();
        String sql = "SELECT pothole_id, latitude, longitude, severity, report_date, inspection_date, " +
                "repair_date, street_name, reported_by FROM potholes";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Pothole pothole = mapRowToPothole(results);
            potholes.add(pothole);
        }
        return potholes;
    }


    @Override
    public Pothole getPotholeById(long id) {
        Pothole temp = new Pothole();
        String sql = "SELECT pothole_id, latitude, longitude, severity, report_date, inspection_date, " +
                "repair_date, street_name, reported_by FROM potholes WHERE pothole_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            temp = mapRowToPothole(results);
        }

        return temp;
    }

    @Override
    public void reportPothole(Pothole pothole) {
        String sql = "INSERT into potholes (latitude, longitude, severity, report_date, inspection_date, " +
                "repair_date, street_name, reported_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING pothole_id";
        jdbcTemplate.queryForObject(sql, Integer.class,
                pothole.getLatitude(),
                pothole.getLongitude(), pothole.getSeverity(), pothole.getReportDate(),
                pothole.getInspectionDate(), pothole.getRepairDate(), pothole.getStreetName(), pothole.getReportedBy());

    }


    @Override
    public void updatePothole(Pothole updatePothole, long id) {
        String sql = "UPDATE potholes SET severity = ?, inspection_date = ?, repair_date = ? WHERE pothole_id = ?";

        jdbcTemplate.update(sql, updatePothole.getSeverity(), updatePothole.getInspectionDate(), updatePothole.getRepairDate(), id);
    }

    @Override
    public void deletePothole(Pothole deletePothole, long id) {
        String sql = "Delete From potholes Where pothole_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Pothole mapRowToPothole(SqlRowSet results) {
        Pothole pothole = new Pothole();
        pothole.setId(results.getLong("pothole_id"));
        pothole.setLatitude(results.getDouble("latitude"));
        pothole.setLongitude(results.getDouble("longitude"));
        pothole.setSeverity(results.getInt("severity"));
        if (results.getDate("report_date") != null) {
            pothole.setReportDate(results.getDate("report_date").toLocalDate());
        }


        if (results.getDate("inspection_date") != null) {
            pothole.setInspectionDate(results.getDate("inspection_date").toLocalDate());
        }
        ;
        if (results.getDate("repair_date") != null) {
            pothole.setRepairDate(results.getDate("repair_date").toLocalDate());
        }


        if (results.getDate("inspection_date") != null) {
            pothole.setInspectionDate(results.getDate("inspection_date").toLocalDate());
        }

        if (results.getDate("repair_date") != null) {
            pothole.setRepairDate(results.getDate("repair_date").toLocalDate());
        }


        pothole.setStreetName(results.getString("street_name"));
        pothole.setReportedBy(results.getLong("reported_by"));
        return pothole;
    }

    private Coords mapRowToCoordinate(SqlRowSet results) {
        Coords coords = new Coords();
        coords.setLabel(results.getLong("pothole_id"));
        coords.setLat(results.getDouble("latitude"));
        coords.setLng(results.getDouble("longitude"));
        return coords;
    }


}
