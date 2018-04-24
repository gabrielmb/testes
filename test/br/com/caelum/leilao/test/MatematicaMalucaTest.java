package br.com.caelum.leilao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.service.MatematicaMaluca;

public class MatematicaMalucaTest {

	@Test
	public void test() {
		
		MatematicaMaluca conta = new MatematicaMaluca();
		
		int r1 = conta.contaMaluca(40);
		int r2 = conta.contaMaluca(20);
		int r3 = conta.contaMaluca(5);
		
		
		assertEquals(160, r1);
		assertEquals(60, r2);
		assertEquals(10, r3);
	}

}
