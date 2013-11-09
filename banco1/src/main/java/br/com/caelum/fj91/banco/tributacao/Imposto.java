package br.com.caelum.fj91.banco.tributacao;

import java.math.BigDecimal;

import br.com.caelum.fj91.banco.modelo.Conta;

public interface Imposto {

	/**
	 * Calcula o desconto que deve ser aplicado a essa Conta
	 * @param conta
	 * @return Desconto a ser efetuado
	 */
	BigDecimal calculaDesconto(Conta conta);

}