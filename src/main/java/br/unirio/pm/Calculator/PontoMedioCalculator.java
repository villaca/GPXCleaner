package br.unirio.pm.Calculator;

import br.unirio.pm.Model.Ponto;

/**
 * Created by Daniel Villaça on 04/10/2016.
 */
public class PontoMedioCalculator {

    private double latitudeMedia(double latitudeAnterior, double latitudeSeguinte){
        double latitudeMedia = latitudeAnterior + ((latitudeSeguinte - latitudeAnterior)/2);
        return latitudeMedia;
    }

    private double longitudeMedia(double longitudeAnterior, double longitudeSeguinte){
        double longitudeMedia = longitudeAnterior + ((longitudeSeguinte - longitudeAnterior)/2);
        return longitudeMedia;
    }

    public Ponto calculaPontoMedio(Ponto pontoAnterior, Ponto pontoSeguinte){
        return new Ponto(latitudeMedia(pontoAnterior.getLatitude(), pontoSeguinte.getLatitude()),
                        longitudeMedia(pontoAnterior.getLongitude(), pontoSeguinte.getLongitude()),
                        0, null);
    }
}
