package main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import model.Produto;
import util.Ultils;

public class Mercado {

    private static ArrayList<Produto> produto;
    private static Map<Produto, Integer> carrinho;
    
    public static void  main(String [] args) {
    
    	produto = new ArrayList<>();
    	carrinho = new HashMap<>();
    	menu();
    }
    private static void menu() {
        int operacao = Integer.parseInt(JOptionPane.showInputDialog("---Selecione uma operação---" +
		"|\nOpção 1 - Cadastrar " +
		"|\nOpção 2 - Listar   " +
		"|\nOpção 3 - Comprar       " +
		"|\nOpção 4 - Carrinho  " +
		"|\nOpção 5 - Sair      "));
    	
    	switch(operacao) {
    	case 1:
    		cadastrarProdutos();
    		break;
    	case 2:
    		listarProdutos();
    		break;
    	case 3:
    		comprarProdutos();
    		break;
    	case 4:
    		verCarrinho();
    		break;
    	case 5:
JOptionPane.showMessageDialog(null, "Obrigado, volte Sempre! ");
		    
			System.exit(0);
			
			
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida	! ");
				menu ();
				break;
    	}
    }
    private static void cadastrarProdutos() {
    	Produto produto = new Produto(null, 0);
    	produto.setNome(JOptionPane.showInputDialog("Nome: "));
    	produto.setPreco(JOptionPane.showInputDialog(null, "Preço :"));
    	
    		
    	
      Mercado.produto.add(produto);
      
      JOptionPane.showMessageDialog(null,produto.getNome() + "Produto cadastrado com sucesso! ");
      menu();
    	
    }
    private static void listarProdutos() {
    	if(produto.size() > 0) {
    		for(Produto p : produto) {
    			JOptionPane.showMessageDialog(null, p);
    		}
    	}else {
    		JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado:");
    	}
    	menu();
    }
    private static void comprarProdutos() {
    	if(produto.size() > 0) {
    		JOptionPane.showMessageDialog(null, "Codigo do Produto: \n");
    		
    	JOptionPane.showMessageDialog(null, "***Produtos disponiveis*** ");
    	   for(Produto p : produto) {
    		   JOptionPane.showMessageDialog(null, p + "\n");
    	   }
    	   int id = Integer.parseInt(JOptionPane.showInputDialog(null));
    	   boolean isPresent = false;
    	   
    	   for(Produto p : produto) {
    		   if(p.getId() == id) {
    			   int qtd = 0;
    			   try {
    				   qtd = carrinho.get(p);
    				   carrinho.put(p, qtd + 1 );
    			   }catch (NullPointerException e) {
    				   carrinho.put(p, 1);
    			   }
    		     JOptionPane.showMessageDialog(null, p.getNome() + "Adicionado ao carrinho! ");
    		     isPresent = true;
    		     
    		     JOptionPane.showMessageDialog(null, "Digite 1 se que continuar fazendo compras! ");
    		     JOptionPane.showConfirmDialog(null, "Digite 0 se você quer sair da compra! \n");
    		     int option = Integer.parseInt(JOptionPane.showInputDialog(null ));
    		     
    		     if(option == 1) {
    		    	 comprarProdutos();
    		     }else {
    		    	 finalizarCompras();    		     }
    		   }    		   
    	   }
    	}else {
    		JOptionPane.showMessageDialog(null, "Produto não encontrado");
    		menu();
    	}
    }

    private static void verCarrinho(){
    	JOptionPane.showMessageDialog(null, "Produtos do carrinho! ");
    	if(carrinho.size() > 0) {
    		for(Produto p : carrinho.keySet()) {
    			JOptionPane.showMessageDialog(null,"Produto: " + p + "\nQuantidade: " + carrinho.get(p));
    		}
    	}else {
    		JOptionPane.showMessageDialog(null, "Carrinho vazio!");
    	}
    	menu();  
    }
    private static void finalizarCompras() {
    	Double valorCompra = 0.0;
    	
    	JOptionPane.showMessageDialog(null, "Seus Produtos!");
    	
    	for(Produto p : carrinho.keySet()) {
    		int qtd = carrinho.get(p);
    		valorCompra += p.getPreco() * qtd;
    		JOptionPane.showMessageDialog(null, p);
    		JOptionPane.showMessageDialog(null, "Quantidade" + qtd);
    	}
    	JOptionPane.showMessageDialog(null, "O valor a sua compra é: " + Ultils.doubleToString( valorCompra));
    	carrinho.clear();
    	menu();
    	
    }
}

  


