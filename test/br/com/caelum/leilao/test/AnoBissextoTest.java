package br.com.caelum.leilao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.service.AnoBissexto;

public class AnoBissextoTest {

	@Test 
	public void verificaSeAnoEhBissexto() {
		
		AnoBissexto calculo = new AnoBissexto();
		
		assertEquals(false,calculo.ehBissexto(2018));
		assertEquals(true,calculo.ehBissexto(2020));
	}
	
}
