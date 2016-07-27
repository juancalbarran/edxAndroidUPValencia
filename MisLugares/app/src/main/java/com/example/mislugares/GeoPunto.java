package com.example.mislugares;

/**
 * Created by juan.albarran on 7/27/2016.
 */
public class GeoPunto {

    private double longitud, latitud;
    private int longitudInt, latitudInt;

    public GeoPunto(int longitudInt, int latitudInt) {
        this.longitudInt = longitudInt;
        this.latitudInt = latitudInt;
    }

    public GeoPunto(double longitud, double latitud) {
        this.longitud= longitud;
        this.latitud= latitud;
    }

    public String toString() {
        return new String("longitud:" + longitud + ", latitud:"+ latitud);
    }

    public double distancia(GeoPunto punto) {
        final double RADIO_TIERRA = 6371000; // en metros
        double dLat = Math.toRadians(latitud - punto.latitud);
        double dLon = Math.toRadians(longitud - punto.longitud);
        double lat1 = Math.toRadians(punto.latitud);
        double lat2 = Math.toRadians(latitud);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) *
                        Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return c * RADIO_TIERRA;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public int getLongitudInt() {
        return longitudInt;
    }

    public void setLongitudInt(int longitudInt) {
        this.longitudInt = longitudInt;
    }

    public int getLatitudInt() {
        return latitudInt;
    }

    public void setLatitudInt(int latitudInt) {
        this.latitudInt = latitudInt;
    }
}
