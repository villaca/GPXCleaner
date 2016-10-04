package br.unirio.pm.Model;

/**
 * Created by Daniel Villaça on 02/10/2016.
 */


import lombok.Setter;
import org.joda.time.DateTime;
import lombok.Getter;

@Getter @Setter
public class Ponto {
    private double latitude;
    private double longitude;
    private double elevação;
    private DateTime tempo;

    /**
     * Inicializa o ponto
     */
    public Ponto(double latitude, double longitude, double elevação, DateTime tempo) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevação = elevação;
        this.tempo = tempo;
    }
}

