package br.unirio.pm.Calculator;

import br.unirio.pm.Model.Ponto;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Daniel Villaça on 04/10/2016.
 */
public class HaversineCalculatorTest {

    @Test
    public void testDistancia() throws Exception {

        Ponto ponto1 = new Ponto(44.02248083, -123.1245669, 0.0, null);
        Ponto ponto2 = new Ponto(44.02268685, -123.1244315, 0.0, null);
        assertEquals(25.33, HaversineCalculator.distancia(ponto1, ponto2), 0.01);
    }

}