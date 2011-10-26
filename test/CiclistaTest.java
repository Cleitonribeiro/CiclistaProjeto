import static org.junit.Assert.*;

import org.junit.Test;

public class CiclistaTest {

@Test
public void deveCalcularMedia() throws CiclistaException {
	double velocidadeMedia = Ciclista.calculaMedia(8.0, 2.0);
	assertEquals(4, velocidadeMedia, 0);
}

@Test
public void valorMinimo() throws CiclistaException {
double valorMinimoCalculado = Ciclista.calculaMedia(9.0, 4.0 );
assertEquals(4.0, valorMinimoCalculado, 0);
}

@Test
public void valorMaximo() throws CiclistaException {
double valorMinimoCalculado = Ciclista.calculaMedia(9.0, 4.0 );
assertEquals(4.0, valorMinimoCalculado, 0);
}

}
