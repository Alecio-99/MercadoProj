package model;

public class Produto {
   private static int count = 1;
   
   private int id;
   private String nome;
   double preco;
public Produto(String nome, double preco) {
	
	this.id = count;
	this.nome = nome;
	this.preco = preco;
	Produto.count += 1;
}
public static int getCount() {
	return count;
}
public static void setCount(int count) {
	Produto.count = count;
}
public int getId() {
	return id;
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getPreco() {
	return preco;
}
public void setPreco(Double preco) {
	this.preco = preco;
}
@Override
public String toString() {
	return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
}
public void setPreco(String showInputDialog) {
	// TODO Auto-generated method stub
	
}
	
	
}
