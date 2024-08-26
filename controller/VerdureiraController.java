package br.com.senai.controller;

import java.util.List;

import br.com.senai.entity.VerdureiraEntity;
import br.com.senai.service.VerdureiraService;

public class VerdureiraController {
	
	VerdureiraService verdureiraService = new VerdureiraService();
	
	public VerdureiraEntity cadastrarProduto(String name, double price, int quantity) {
		return verdureiraService.cadastrarProduto(name, price, quantity);
	}
	
	public void listarProdutos(List<VerdureiraEntity> listaProdutos) {
		verdureiraService.listarProdutos(listaProdutos);
	}
	
	public VerdureiraEntity editarProduto(VerdureiraEntity verdureiraEntity) {
		return verdureiraService.editarProduto(verdureiraEntity);
	}
	
	public void removerProduto(List<VerdureiraEntity> listaProdutos, int id) {
		verdureiraService.removerProduto(listaProdutos, id);
	}
	
	public VerdureiraEntity buscarProduto(int id, List<VerdureiraEntity> listaProdutos) {
		return verdureiraService.buscarProduto(id, listaProdutos);
	}
}