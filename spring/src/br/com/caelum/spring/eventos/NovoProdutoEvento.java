package br.com.caelum.spring.eventos;

import org.springframework.stereotype.Service;

import br.com.caelum.spring.annotation.Observer;
import br.com.caelum.spring.modelo.Produto;

@Service
public class NovoProdutoEvento {
	
	public void initProcessRecordProduto(@Observer Produto produto) {
		System.out.println("Passou aqui com o produto: "+ produto.getNome());
	}
	
	public void dead(@Observer Produto produto) {
		System.out.println("2222: "+ produto.getNome());
	}

}
