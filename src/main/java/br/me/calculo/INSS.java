package br.me.calculo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class INSS {
	
	public static final String PORTARIA = "Portaria SEPRT 3.659/2020";

	public static final String VIGENCIA = "Vigência de 01.03.2020 a 31.12.2020";

	private final static Double LIMITE[] = { 1045.00D, 2089.60D, 3134.40D, 6101.06D };

	private final static Double ALIQUOTA[] = { 0.075D, 0.09D, 0.12D, 0.14D };

	public static Double ALIQ(int i) {
		return ALIQUOTA[i - 1];
	}

	public static Double LIM(int i) {
		return LIMITE[i - 1];
	}

	public static Double calcular(Double V) {

		// Ler ALIQ(i), LIM(i)

		// FX(i) = 0.0
		Map<Integer, Double> faixa = new HashMap<Integer, Double>();

		// Solicitar valor base, V
		// Double V = 2100;

		// Se V < LIM(1) então FX(1) = V senão FX(1) = LIM(1)
		if (V < LIM(1)) faixa.put(1, V); else faixa.put(1, LIM(1));

		// Para i de 2 a 5 faça
		for (int i = 2; i < 5; i++) {

			// se V > LIM(i-1) AND V < LIM(i)
			if (V > LIM(i - 1) && V <= LIM(i)) {

				// então FX(i) = V - LIM(i-1)
				faixa.put(i, V - LIM(i - 1));
			}
		}

		// Para i de 2 a 5 faça
		for (int i = 2; i < 5; i++) {

			// se V > LIM(i)
			if (V > LIM(i)) {

				// então FX(i) = LIM(i) - LIM(i-1)
				faixa.put(i, LIM(i) - LIM(i - 1));
				
			}
			
		}

		// IN = 0.0
		Double IN = 0D;

		// Para i de 1 a 5 faça
		for (int i = 1; i < 5; i++) {

			if (i <= faixa.values().size()) {
				
				// IN = IN + FX(i) * ALIQ(i)
				IN += faixa.get(i) * ALIQ(i);
			}
		}

		return round(IN);
	}

	public static Double truncate(Double valor) {
		BigDecimal bigvalor = new BigDecimal(valor);
		return bigvalor.setScale(2, RoundingMode.DOWN).doubleValue();
	}
	
	public static double round(double valor) {		
		return BigDecimal.valueOf(valor).setScale(2, RoundingMode.UP).doubleValue();
	}
	
}
