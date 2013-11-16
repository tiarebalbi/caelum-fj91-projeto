package br.com.caelum.dsl;

public enum Meses {
	JANEIRO(0),
	FEVEREIRO(1);
	
	private Integer mes;

	private Meses (Integer mes) {
		this.mes = mes;
	}
	
	public Integer getMes() {
		return mes;
	}
}
