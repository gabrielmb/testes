package br.com.caelum.leilao.service;

import java.time.LocalDate;

public class AnoBissexto {

	
	public boolean ehBissexto(int ano) {
		return LocalDate.of(ano, 1, 1).isLeapYear();
	}
}
