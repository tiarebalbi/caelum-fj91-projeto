package br.com.caelum.spring.action;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.spring.dao.Produtos;
import br.com.caelum.spring.modelo.Produto;
import br.com.caelum.spring.process.Event;

public class NovoProdutoAction {
	
	private Produtos produtos;
	
	@Autowired
	private Event<Produto> produtoEvent;

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	public void lerDados(){
		Scanner produtoReader = new Scanner(System.in);
		System.out.print("Digite o nome:");
		String nome = produtoReader.next();
		System.out.print("Digite o preco:");
		double preco = produtoReader.nextDouble();
		Produto produto = new Produto(nome, preco);
		produtos.cadastra(produto);
		produtoEvent.fire(produto);
	}

}
