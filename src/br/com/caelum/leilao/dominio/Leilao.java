package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	private final long MAXIMO_DE_LANCES = 5;

	public Leilao(String descricao) {

		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {

		if (lances.isEmpty() || (ultimoLanceDado(lance.getUsuario()) && podeDarMaisLances(lance.getUsuario()))) {
			lances.add(lance);
		}
	}

	private boolean podeDarMaisLances(Usuario usuario) {
		
		long qtdLances = lances.stream().filter(lance -> lance.getUsuario().equals(usuario)).count();
		
		return lances.isEmpty() || qtdLances < MAXIMO_DE_LANCES ;
	}

	private boolean ultimoLanceDado(Usuario usuario) {
		return lances.isEmpty() ? true : !lances.get(lances.size() - 1).getUsuario().equals(usuario);
	}

	public String getDescricao() {

		return descricao;
	}

	public List<Lance> getLances() {

		return Collections.unmodifiableList(lances);
	}

	public void dobraLance(Usuario user) {
		
		if(!lances.isEmpty()) {
			double valor = 0.0;
			for(int x = lances.size() -1; x >= 0 ; x--) {
				if(lances.get(x).getUsuario().equals(user)) {
					valor = lances.get(x).getValor() * 2;
					break;
				}
			}
			if(valor != 0) this.propoe(new Lance(user, valor));
		}
	}

}
