import static org.junit.Assert.*;

import org.junit.Test;

import br.me.calculo.Calculo;

public class CalculoRecolhimentoINSS {

	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa1() {
		float limite = 1045.00f + 0.01f;
		assertEquals(0.004f, 78.375 , Calculo.executar(limite));		
	}

	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa2() {
		float limite = 2089.60f + 0.01f;
		assertEquals(0.010f, 173.637 , Calculo.executar(2100f));
		assertEquals(0.010f, 172.39 , Calculo.executar(limite));
	}
	

	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa3() {
		float limite =  3134.40f + 0.01f;	
		assertEquals(0.004f, 281.64 , Calculo.executar(3000f));
		assertEquals(0.004f, 713.10 , Calculo.executar(limite));
	}
	
	@Test
	public void deveValidarCorretamenteCalculosDeDeducaoINSS_Faixa4() {
		float limite =  6101.06f + 0.01f;
		//assertEquals(0.004f, 713.0974 , Calculo.executar(limite));
	}

}
