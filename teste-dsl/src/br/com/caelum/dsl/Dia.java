package br.com.caelum.dsl;

import java.util.Calendar;

public class Dia {
	
	private Integer dia;
	private Integer mes;
	private Integer ano;

	public Dia(Integer dia) {
		this.dia = dia;
	}
	
	public Dia() {
	}

	public Ano de(Meses meses) {
		if(dia == null) {throw new RuntimeException("Você precisa informar o dia");}
		mes = meses.getMes();
		return new Ano();
	}
	
	public Dia numero(Integer diaRef) {
		dia = diaRef;
		return this;
	}
	
	public class Ano {
		private Ano() {}
		
		public Calendar de(Integer anoRef) {
			ano = anoRef;
			Calendar calendario = Calendar.getInstance();
			calendario.set(Calendar.DAY_OF_MONTH, dia);
			calendario.set(Calendar.MONTH, mes);
			calendario.set(Calendar.YEAR, ano);
			return calendario;
		}
	}

}
