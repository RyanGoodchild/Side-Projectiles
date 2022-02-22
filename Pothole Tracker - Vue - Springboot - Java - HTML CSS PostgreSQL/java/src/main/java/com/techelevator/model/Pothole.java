package com.techelevator.model;

import java.time.LocalDate;

public class Pothole {

    private long id;
    private double latitude;
    private double longitude;
    private int severity;
    private LocalDate reportDate;
    private LocalDate inspectionDate;
    private LocalDate repairDate;
    private String streetName;
    private long reportedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public long getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(long reportedBy) {
        this.reportedBy = reportedBy;
    }

    @Override
    public String toString() {
        return "Pothole{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", severity=" + severity +
                ", reportDate=" + reportDate +
                ", inspectionDate=" + inspectionDate +
                ", repairDate=" + repairDate +
                ", streetName='" + streetName + '\'' +
                ", reportedBy=" + reportedBy +
                '}';
    }
}
