package br.me.calculo;

import java.util.HashMap;
import java.util.Map;

public class Calculo {
	
	private final static float aliquota[] = { 0.075F, 0.09F, 0.12F, 0.14F };
	private final static float limite[] = { 1045.00F, 2089.60F, 3134.40F, 6101.06F };

	private static float ALIQ(int i) {
		return aliquota[i-1];
	}

	private static float LIM(int i) {
		return limite[i-1];
	}	
	
	public static float executar(float V) {
		
		//Ler ALIQ(i), LIM(i)		

		//FX(i) = 0.0
		Map<Integer, Float> FX = new HashMap<Integer, Float>();
		
		//Solicitar valor base, V		
		//float V = 2100;
		
		//Se V < LIM(1) então FX(1) = V senão FX(1) = LIM(1)
		if(V < LIM(1) ) FX.put(1, V); else FX.put(1, LIM(1));
		
		//Para i de 2 a 5 faça
		for (int i = 2; i < 5; i++) {
			
			//	se V > LIM(i-1) AND V < LIM(i)
			if(V > LIM(i-1) && V < LIM(i) ) { 
			
				//	então FX(i) = V - LIM(i-1)
				FX.put(i, V - LIM(i-1));
			}
		}
		
		//Para i de 2 a 5 faça		
		for (int i = 2; i < 5; i++) {

			if (i==4)
				System.out.println();
			//	se V > LIM(i)	
			if(V > LIM(i)) {
			
				//	então FX(i) = LIM(i) - LIM(i-1)
				FX.put( i, LIM(i) - LIM(i-1) );
			}
		}
		
		//IN = 0.0
		float IN = 0F; 
		
		//Para i de 1 a 5 faça		
		for (int i = 1; i < 5; i++) {
		
			if(i <= FX.values().size()) {
				//	IN = IN + FX(i) * ALIQ(i)
				IN += FX.get(i) * ALIQ(i);
			}
		}
		
		return IN;
	}

}
