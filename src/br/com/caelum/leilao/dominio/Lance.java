package br.com.caelum.leilao.dominio;

public class Lance {

	private Usuario usuario;
	private double valor;

	public Lance(Usuario usuario, double valor) {
		if(valor == 0) throw new RuntimeException("O valor do lance deve ser maior que 0(Zero).");
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {

		return usuario;
	}

	public double getValor() {

		return valor;
	}

}
