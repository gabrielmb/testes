package br.com.caelum.leilao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

		assertEquals(2, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000, leilao.getLances().get(1).getValor(), 0.00001);
	}

	@Test
	public void naoDeveAceitarDoisLancesEmSequencia() {
		Leilao leilao = new Leilao("Mochila Red Hot Chilli Peppers");

		Usuario usuario = new Usuario("Gabriel");

		leilao.propoe(new Lance(usuario, 50.0));
		leilao.propoe(new Lance(usuario, 20.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(50.0, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");

		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 4000));
		leilao.propoe(new Lance(billGates, 5000));
		leilao.propoe(new Lance(steveJobs, 6000));
		leilao.propoe(new Lance(billGates, 7000));
		leilao.propoe(new Lance(steveJobs, 8000));
		leilao.propoe(new Lance(billGates, 9000));
		leilao.propoe(new Lance(steveJobs, 10000));
		leilao.propoe(new Lance(billGates, 11000));

		// deve ser ignorado
		leilao.propoe(new Lance(steveJobs, 12000));

		assertEquals(10, leilao.getLances().size());
		int ultimo = leilao.getLances().size() - 1;
		Lance ultimoLance = leilao.getLances().get(ultimo);
		assertEquals(11000.0, ultimoLance.getValor(), 0.00001);
	}

	@Test
	public void dobraLanceDado() {
		Leilao leilao = new Leilao("Mochila Red Hot Chilli Peppers");

		Usuario gabriel = new Usuario("Gabriel");
		Usuario zezim = new Usuario("Zezim");

		leilao.propoe(new Lance(gabriel, 50.0));
		leilao.propoe(new Lance(zezim, 200.0));
		leilao.propoe(new Lance(gabriel, 300.0));
		leilao.propoe(new Lance(zezim, 400.0));
		
		leilao.dobraLance(gabriel);
		
		double valorUltimoLance = leilao.getLances().get(leilao.getLances().size() -1).getValor();
		
		assertEquals(600.0,valorUltimoLance,0.00001);
	}
	
	@Test
	public void naoDobraLancePoisNaoDeuLance() {
		Leilao leilao = new Leilao("Mochila Red Hot Chilli Peppers");

		Usuario gabriel = new Usuario("Gabriel");
		Usuario zezim = new Usuario("Zezim");
		
		Usuario enguia = new Usuario("Enguia");

		leilao.propoe(new Lance(gabriel, 50.0));
		leilao.propoe(new Lance(zezim, 200.0));
		
		leilao.propoe(new Lance(gabriel, 100.0));
		
		leilao.propoe(new Lance(zezim, 200.0));
		
		leilao.dobraLance(enguia);
		
		double valorUltimoLance = leilao.getLances().get(leilao.getLances().size() -1).getValor();
		
		assertEquals(200.0,valorUltimoLance,0.00001);
	}

}
