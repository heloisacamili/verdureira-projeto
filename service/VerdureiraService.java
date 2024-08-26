package br.com.senai.service;

import java.util.List;
import java.util.Scanner;

import br.com.senai.entity.VerdureiraEntity;

public class VerdureiraService {
	
	private Scanner sc = new Scanner(System.in);
	
	public VerdureiraEntity cadastrarProduto(String name, double price, int quantity) {
		VerdureiraEntity verdureiraEntity = new VerdureiraEntity();
		verdureiraEntity.setProductName(name);
		verdureiraEntity.setPrice(price);
		verdureiraEntity.setQuantity(quantity);
		return verdureiraEntity;
	}
	
	public void listarProdutos(List<VerdureiraEntity> listaProdutos) {
		for (int i = 0; i < listaProdutos.size(); i++) {
            VerdureiraEntity produto = listaProdutos.get(i);
            System.out.println("ID: " + i);
            System.out.println("Produto: " + produto.getProductName());
            System.out.printf("Valor unitário: R$%.2f\n", produto.getPrice());
            System.out.println("Quantidade: " + produto.getQuantity());
            System.out.println();
        }
//		listaProdutos.forEach(produto -> {
//			System.out.println("Produto: " + produto.getProductName());
//			System.out.printf("Valor unitário: R$%.2f", produto.getPrice());
//			System.out.println("\nQuantidade: " + produto.getQuantity());
//		});
	}
	
	public VerdureiraEntity editarProduto(VerdureiraEntity verdureiraEntity) {
		System.out.println("Informe o campo a ser editado: \n1- Nome do produto\n2- Valor unitário\n3- Quantidade\n4- Todos");
		int optionEdit = sc.nextInt();
		sc.nextLine();

		switch(optionEdit) {
			case 1 -> {
				System.out.print("Informe o novo nome: ");
				verdureiraEntity.setProductName(sc.nextLine());
			}
			case 2 -> {
				System.out.print("Informe o novo valor unitário: R$");
				verdureiraEntity.setPrice(sc.nextDouble());
			}
			case 3 -> {
				System.out.print("Informe a nova quantidade: ");
				verdureiraEntity.setQuantity(sc.nextInt());
			}
			case 4 -> {
				System.out.print("Informe o novo nome: ");
				verdureiraEntity.setProductName(sc.nextLine());
				System.out.print("Informe o novo valor unitário: R$");
				verdureiraEntity.setPrice(sc.nextDouble());
				System.out.print("Informe a nova quantidade: ");
				verdureiraEntity.setQuantity(sc.nextInt());
			}
			default -> {
				System.out.println("Informe uma opção válida!");
			}
		}
		return verdureiraEntity;
	}
	
	public void removerProduto(List<VerdureiraEntity> listaProdutos, int id) {
		listaProdutos.remove(id);
	}
	
	public VerdureiraEntity buscarProduto(int id, List<VerdureiraEntity> listaProdutos) {
		if (id >= 0 && id < listaProdutos.size()) {
			return listaProdutos.get(id);
		} else {
			System.out.println("Produto não encontrado!");
			return null;
		}
	}
}
