package br.com.caelum.fj91.banco.modelo;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Organiza as contas do banco por semestre de abertura
 */
public class Contas {

	private int totalContasPrimeiroSemestre = 0;
	private int totalContasSegundoSemestre = 0;
	
	private Set<Conta> contas = new HashSet<Conta>();
	
	public int size() {
		return contas.size();
	}

	public boolean add(Conta conta) {
		int mes = conta.getDataAbertura().get(Calendar.MONTH);
		if (mes < 6) {
			totalContasPrimeiroSemestre++;
		} else {
			totalContasSegundoSemestre++;
		}
		
		return contas.add(conta);
	}

	public boolean addAll(Collection<? extends Conta> c) {
		for (Conta conta : c) {
			int mes = conta.getDataAbertura().get(Calendar.MONTH);
			if (mes < 6) {
				totalContasPrimeiroSemestre++;
			} else {
				totalContasSegundoSemestre++;
			}
		}
		
		return contas.addAll(c);
	}
	
	public int getTotalContasPrimeiroSemestre() {
		return totalContasPrimeiroSemestre;
	}
	
	public int getTotalContasSegundoSemestre() {
		return totalContasSegundoSemestre;
	}
	
}
