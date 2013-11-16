package br.com.caelum.dsl;

import java.util.Calendar;

public class Runner {

	public void main(String[] args) {
		Calendar data = new Dia(20).de(Meses.FEVEREIRO).de(2013);
		System.out.println(data.getTime());
		
	}
	
}