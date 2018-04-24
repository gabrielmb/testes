package br.com.caelum.leilao.service;

import javax.management.RuntimeErrorException;

import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;
	private double lanceMedio = 0;

	public void avalia(Leilao leilao) {

		if(leilao.getLances().isEmpty()) {
			throw new RuntimeException("Leilão não possui lances para avaliar");
		}
		
		leilao.getLances().stream().forEach(lance -> {

			if (lance.getValor() > maiorLance) {
				maiorLance = lance.getValor();
			}
			if (lance.getValor() < menorLance) {
				menorLance = lance.getValor();
			}

		});

		if (leilao.getLances().size() == 0)
			return;

		lanceMedio = leilao.getLances().stream().mapToDouble(lance -> lance.getValor()).sum();

		lanceMedio = lanceMedio / leilao.getLances().size();

	}

	public double getMaiorLance() {

		return maiorLance;
	}

	public double getMenorLance() {

		return menorLance;
	}

	public double getLanceMedio() {
		return lanceMedio;
	}

}
