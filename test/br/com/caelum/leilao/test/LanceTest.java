package br.com.caelum.leilao.test;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class LanceTest {

	private Usuario u1;

	@Before
	public void contrutorUsuario() {
		u1 = new Usuario("Gabriel");
	}
	
	@Test(expected=RuntimeException.class) 
	public void lanceNaoPodeTerValorZerado() {
		new Lance(u1,0.0);
	}
}
