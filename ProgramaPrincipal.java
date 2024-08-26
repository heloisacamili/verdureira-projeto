package br.com.senai;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.senai.controller.VerdureiraController;
import br.com.senai.entity.VerdureiraEntity;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        ArrayList<VerdureiraEntity> listaProdutos = new ArrayList<>();
        
        int quantidadeEstoque = 0;
        double valorEstoque = 0;
        
        boolean repetir = true;
        
        VerdureiraController verdureiraController = new VerdureiraController();
        
        while (repetir) {
            System.out.println("--- MENU ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Editar produto");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Encerrar Sistema");
            int option = sc.nextInt();
            sc.nextLine();  

            switch(option) {
                case 1 -> {
                    System.out.println("\n--- Cadastrar Produto ---");
                    System.out.print("Informe o nome do produto: ");    
                    String name = sc.nextLine();
                    System.out.print("Informe o valor: R$");
                    double price = sc.nextDouble();
                    System.out.print("Informe a quantidade: ");
                    int quantity = sc.nextInt();
                    System.out.println("\n");
                    
                    VerdureiraEntity verdureiraEntity = verdureiraController.cadastrarProduto(name, price, quantity);
                    listaProdutos.add(verdureiraEntity);
                    quantidadeEstoque += quantity;
                    valorEstoque += price * quantity;
                }
                case 2 -> {
                    System.out.println("\n--- Listar Produtos ---");
                    verdureiraController.listarProdutos(listaProdutos);
                    System.out.println("Quantidade total de itens em estoque: " + quantidadeEstoque);
                    System.out.printf("Valor total em estoque: R$%.2f\n", valorEstoque);
                    System.out.println("\n");
                }
                case 3 -> {
                    System.out.println("\n--- Buscar Produto ---");
                    System.out.print("Informe o ID do produto: ");
                    int id = sc.nextInt();
                    VerdureiraEntity produtoBuscado = verdureiraController.buscarProduto(id, listaProdutos);
                    if (produtoBuscado != null) {
                        System.out.println("Produto encontrado: " + produtoBuscado.getProductName());
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.println("\n--- Editar Produto ---");
                    System.out.print("Informe o ID do produto: ");
                    int id = sc.nextInt();
                    if (id >= 0 && id < listaProdutos.size()) {
                        VerdureiraEntity verdureiraEntityEdit = listaProdutos.get(id);
                        VerdureiraEntity verdureiraEntityEdited = verdureiraController.editarProduto(verdureiraEntityEdit);
                        listaProdutos.set(id, verdureiraEntityEdited);
                    } else {
                        System.out.println("Nenhum registro encontrado.");
                    }
                }
                case 5 -> {
                    System.out.println("\n--- Remover Produto ---");
                    System.out.print("Informe o ID do produto a ser removido: ");
                    int id = sc.nextInt();
                    if (id >= 0 && id < listaProdutos.size()) {
                        VerdureiraEntity produtoRemovido = listaProdutos.remove(id);
                        quantidadeEstoque -= produtoRemovido.getQuantity();
                        valorEstoque -= produtoRemovido.getPrice() * produtoRemovido.getQuantity();
                        System.out.println("Produto removido com sucesso.");
                    } else {
                        System.out.println("Nenhum item na lista com o ID informado!");
                    }
                }
                case 6 -> {
                    repetir = false;
                    System.out.println("\nSistema encerrado.");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
