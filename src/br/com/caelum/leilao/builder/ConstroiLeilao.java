package br.com.caelum.leilao.builder;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class ConstroiLeilao {

	private Leilao leilao;

	public ConstroiLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public ConstroiLeilao lance(Lance lance) {
		leilao.propoe(lance);
		return this;
	}

	public Leilao constroi() {
		return leilao;
	}
	
}
