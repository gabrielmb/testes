package br.com.caelum.leilao.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.ConstroiLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.service.Avaliador;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario u1;
	private Usuario u2;
	private Usuario u3;

	@Before
	public void constroiAvaliador() {
		leiloeiro = new Avaliador();
		u1 = new Usuario("José");
		u2 = new Usuario("João");
		u3 = new Usuario("Maria");
		//System.out.println("cria avaliador");
	}

	@Test(expected = RuntimeException.class)
	public void avaliandoLeilaoSemLances() {
		Leilao leilao = new ConstroiLeilao().para("PS3 na caixa com 5 jogos").constroi();

		leiloeiro.avalia(leilao);
	}

	@Test
	public void generic() {

		Leilao leilao = new ConstroiLeilao().para("PS3 na caixa com 5 jogos").lance(new Lance(u1, 400))
				.lance(new Lance(u2, 300)).lance(new Lance(u3, 600)).constroi();

		leiloeiro.avalia(leilao);

		double maiorLanceEsperado = 600;
		double menorLanceEsperado = 300;

		double medialance = 1300.0 / 3.0;

		assertEquals(maiorLanceEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorLanceEsperado, leiloeiro.getMenorLance(), 0.0001);
		assertEquals(medialance, leiloeiro.getLanceMedio(), 0.0001);

	}

	@Test
	public void comApenasUmLance() {

		Leilao leilao = new ConstroiLeilao().para("PS3 na caixa com 5 jogos").lance(new Lance(u1, 200)).constroi();

		leiloeiro.avalia(leilao);

		double media = 200.0 / 1.0;

		assertEquals(200, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(200, leiloeiro.getMenorLance(), 0.0001);
		assertEquals(media, leiloeiro.getLanceMedio(), 0.0001);
	}

	@After
	public void finaliza() {
		//System.out.println("Fim");
	}
}
