package br.com.caelum.leilao.test;

import org.junit.Test;

import br.com.caelum.leilao.service.Palindromo;
import junit.framework.Assert;

public class PalindromoTest {
    
    @Test
    public void test() {
	
	String frasePalindromo = "Socorram-me subi no onibus em Marrocos";
	
	String fraseNaoPalindromo = "Gabriel MOrais";
	
	String stringVazia = "";
	
	Palindromo verificador = new Palindromo();
	
	Assert.assertEquals( true,
		verificador.ehPalindromo( frasePalindromo ) );
	Assert.assertEquals( false,
		verificador.ehPalindromo( fraseNaoPalindromo ) );
	Assert.assertEquals( false,
		verificador.ehPalindromo( stringVazia ) );
    }
    
}
