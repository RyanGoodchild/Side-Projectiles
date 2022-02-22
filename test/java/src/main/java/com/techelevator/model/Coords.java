package com.techelevator.model;

public class Coords {

    private long label;
    private double lat;
    private double lng;

    public long getLabel() {
        return label;
    }

    public void setLabel(long label) {
        this.label = label;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double latitude) {
        this.lat = latitude;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double longitude) {
        this.lng = longitude;
    }

    @Override
    public String toString() {
        return "Coords{" +
                "label=" + label +
                ", latitude=" + lat +
                ", longitude=" + lng +
                '}';
    }
}