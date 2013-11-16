package br.com.caelum.spring.process;

public interface Event<T> {
	
	void fire(T event);

}
