package br.unirio.pm.Calculator;

import br.unirio.pm.Model.Ponto;

/**
 * Created by Daniel Villaça on 04/10/2016.
 */
public class HaversineCalculator {

    private static final double RAIO_TERRESTRE = 6371008;       // em metros

    /*
     * @param angulo em radianos
     */
    private static double haversine(double angulo){
        return (1 - Math.cos(angulo))/2;
    }

    public static double distancia(Ponto pontoRemovido, Ponto pontoMaisProximo){
        double latitudeRemovidaRadianos = Math.toRadians(pontoRemovido.getLatitude());
        double latitudeProximaRadianos = Math.toRadians(pontoMaisProximo.getLatitude());
        double longitudeRemovidaRadianos = Math.toRadians(pontoRemovido.getLongitude());
        double longitudeProximaRadianos = Math.toRadians(pontoMaisProximo.getLongitude());

        double distancia = haversine(latitudeRemovidaRadianos - latitudeProximaRadianos)
                            + Math.cos(latitudeRemovidaRadianos) * Math.cos(latitudeProximaRadianos)
                            * haversine(longitudeRemovidaRadianos - longitudeProximaRadianos);
        if(distancia > 1){
            distancia = 1;
        }

        distancia = 2 * RAIO_TERRESTRE * Math.asin (Math.sqrt(distancia));
        return distancia;
    }

}
