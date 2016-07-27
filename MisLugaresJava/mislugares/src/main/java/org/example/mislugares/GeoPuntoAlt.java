package org.example.mislugares;

/**
 * Created by juan.albarran on 7/27/2016.
 */
public class GeoPuntoAlt extends GeoPunto {

    private double altitud;

    public GeoPuntoAlt(double longitud, double latitud, double altitud) {
        super(longitud, latitud);
        this.altitud = altitud;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }
}
