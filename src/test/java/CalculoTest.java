import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.me.calculo.Calculo;

public class CalculoTest {

	
	private static final double DELTA = 0.0099D;

	@Test
	public void testeValorAvulso() {
		
		assertEquals( 173.64, Calculo.executar(2100D), DELTA);
		
	}	
	
	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa1() {
		
		Double  menorValor = 1D,
				valorMedio = Calculo.LIM(1) - 1,
				maiorValor = Calculo.LIM(1);

		assertEquals( 0.08 , Calculo.executar(menorValor), DELTA);
		
		assertEquals( 78.30 , Calculo.executar(valorMedio), DELTA);
		
		assertEquals( 78.38 , Calculo.executar(maiorValor), DELTA);		
		
	}

	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa2() {
		
		Double  menorValor = Calculo.LIM(1) + 1,
				valorMedio = Calculo.LIM(2) - 1,
				maiorValor = Calculo.LIM(2);
		
		assertEquals( 78.47 , Calculo.executar(menorValor), DELTA);
		
		assertEquals( 172.30 , Calculo.executar(valorMedio), DELTA);
		
		assertEquals( 172.39 , Calculo.executar(maiorValor), DELTA);		
		
	}

	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa3() {

		Double  menorValor = Calculo.LIM(2) + 1,
				valorMedio = Calculo.LIM(3) - 1,
				maiorValor = Calculo.LIM(3);
		
		assertEquals( 172.51 , Calculo.executar(menorValor), DELTA);
		
		assertEquals( 297.65 , Calculo.executar(valorMedio), DELTA);
		
		assertEquals( 297.77 , Calculo.executar(maiorValor), DELTA);		
		
	}
	
	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa4() {

		Double  menorValor = Calculo.LIM(3) + 1,
				valorMedio = Calculo.LIM(4)-1,
				maiorValor = Calculo.LIM(4);
		
		assertEquals( 297.91 , Calculo.executar(menorValor), DELTA);
		
		assertEquals( 712.96 , Calculo.executar(valorMedio), DELTA);
		
		assertEquals( 713.10 , Calculo.executar(maiorValor), DELTA);		
		
	}
	
	
	@Test
	public void devetruncar() {
		 assertEquals( 25.35D , Calculo.truncate(25.358), DELTA);
	}
	
	@Test
	public void deveArredondar() {
		 assertEquals( 25.36D , Calculo.round(25.358), DELTA);
	}
}
