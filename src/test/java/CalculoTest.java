import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.me.calculo.INSS;

public class CalculoTest {

	
	private static final double DELTA = 0.0099D;

	@Test
	public void testeValorAvulso() {
		
		assertEquals( 173.64, INSS.calcular(2100D), DELTA);
		
	}	
	
	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa1() {
		
		Double  menorValor = 1D,
				valorMedio = INSS.LIM(1) - 1,
				maiorValor = INSS.LIM(1);

		assertEquals( 0.08 , INSS.calcular(menorValor), DELTA);
		
		assertEquals( 78.30 , INSS.calcular(valorMedio), DELTA);
		
		assertEquals( 78.38 , INSS.calcular(maiorValor), DELTA);		
		
	}

	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa2() {
		
		Double  menorValor = INSS.LIM(1) + 1,
				valorMedio = INSS.LIM(2) - 1,
				maiorValor = INSS.LIM(2);
		
		assertEquals( 78.47 , INSS.calcular(menorValor), DELTA);
		
		assertEquals( 172.30 , INSS.calcular(valorMedio), DELTA);
		
		assertEquals( 172.39 , INSS.calcular(maiorValor), DELTA);		
		
	}

	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa3() {

		Double  menorValor = INSS.LIM(2) + 1,
				valorMedio = INSS.LIM(3) - 1,
				maiorValor = INSS.LIM(3);
		
		assertEquals( 172.51 , INSS.calcular(menorValor), DELTA);
		
		assertEquals( 297.65 , INSS.calcular(valorMedio), DELTA);
		
		assertEquals( 297.77 , INSS.calcular(maiorValor), DELTA);		
		
	}
	
	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa4() {

		Double  menorValor = INSS.LIM(3) + 1,
				valorMedio = INSS.LIM(4)-1,
				maiorValor = INSS.LIM(4);
		
		assertEquals( 297.91 , INSS.calcular(menorValor), DELTA);
		
		assertEquals( 712.96 , INSS.calcular(valorMedio), DELTA);
		
		assertEquals( 713.10 , INSS.calcular(maiorValor), DELTA);		
		
	}
	
	
	@Test
	public void devetruncar() {
		 assertEquals( 25.35D , INSS.truncate(25.358), DELTA);
	}
	
	@Test
	public void deveArredondar() {
		 assertEquals( 25.36D , INSS.round(25.358), DELTA);
	}
}
