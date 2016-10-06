package br.unirio.pm.Calculator;

import br.unirio.pm.Model.Ponto;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Daniel Villaça on 04/10/2016.
 */

@Getter @Setter
public class PontoMaisProximoCalculator {

    private Ponto pontoAnterior;
    private Ponto pontoSeguinte;

    public PontoMaisProximoCalculator(Ponto pontoAnterior, Ponto pontoSeguinte) {
        this.pontoAnterior = pontoAnterior;
        this.pontoSeguinte = pontoSeguinte;
    }

    private double inclinacaoRetaResultante(){
        double inclinacao = (pontoAnterior.getLongitude() - pontoSeguinte.getLongitude())
                                / (pontoAnterior.getLatitude() - pontoSeguinte.getLatitude()) ;
        return inclinacao;
    }

    private double constanteDeslocada(){
        double constante = pontoAnterior.getLatitude()
                    - (inclinacaoRetaResultante() * pontoAnterior.getLongitude());
        return constante;
    }

    private double inclinacaoRetaOrtogonal(){
        double inclinacao = - 1 / inclinacaoRetaResultante();
        return inclinacao;
    }

    private double constanteDeslocadaOrtogonal(Ponto pontoRemovido){
        double constante = pontoRemovido.getLatitude() - (inclinacaoRetaOrtogonal() * pontoRemovido.getLongitude());
        return constante;
    }

    private double latitudeProxima(Ponto pontoRemovido){
        double latitude = (inclinacaoRetaResultante() * pontoRemovido.getLongitude()) + constanteDeslocada();
        return latitude;
    }
    private double longitudeProxima(Ponto pontoRemovido){
        double longitude = (constanteDeslocadaOrtogonal(pontoRemovido) - constanteDeslocada())
                            / (inclinacaoRetaResultante() - inclinacaoRetaOrtogonal());
        return longitude;
    }


    public Ponto calculaPontoMaisProximo(Ponto pontoRemovido){
        return new Ponto(longitudeProxima(pontoRemovido), latitudeProxima(pontoRemovido), 0, null);
    }
}
