package models;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import operacoes.Operacoes;
import operacoes.Operavel;

public class Medicamento implements Operavel {

    private int codigo;
    private String descricao;
    private int qtdeEstoque;
    private int qtdEstoqueMaximo;
    private int qtdEstoqueMinimo;
    private double preco;
    private int status = 0;

    private static List<Medicamento> dados = new ArrayList<>();
    private static List<Indice> indices = new ArrayList<>();
    private static int cont;

    public Medicamento() { }

    public static List<Medicamento> getDados() { return dados; }
    public static List<Indice> getIndices() { return indices; }
    
    public int getCont() { return cont; }
    public void setCont(int cont) { Medicamento.cont = cont;}
     
    @Override
    public int getCodigo() { return codigo; }
    @Override	
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    @Override
    public int getStatus() { return status; }
    @Override
    public void setStatus(int valor) { this.status = valor >= 0 && valor < 2 ? valor : this.status; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getQtdeEstoque() { return qtdeEstoque; }
    public void setQtdeEstoque(int qtdeEstoque) { this.qtdeEstoque = qtdeEstoque; }

    public int getQtdEstoqueMaximo() { return qtdEstoqueMaximo; }
    public void setQtdEstoqueMaximo(int qtdeEstoqueMaximo) { this.qtdEstoqueMaximo = qtdeEstoqueMaximo; }

    public int getQtdEstoqueMinimo() { return qtdEstoqueMinimo; }
    public void setQtdEstoqueMinimo(int qtdEstoqueMinimo) { this.qtdEstoqueMinimo = qtdEstoqueMinimo; }
    
    public double getPreco() { return preco; } 
    public void setPreco(double preco) { this.preco = preco >= 0 ? preco : this.preco;  } 
   
    @Override
    public String toString() { 
    	return "\nCodigo: " + this.codigo  + " Descrição: " + this.descricao
    			+ "\nEstoque atual: " + this.getQtdeEstoque()
    			+ "\nEstoque máximo: " + this.getQtdEstoqueMaximo()
    			+ "\nEstoque minímo: " + this.getQtdEstoqueMinimo()
    			+ "\nPreço unitário: R$" + this.getPreco();
    }
    
    public static void consultarMedicamento() {
    	int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do medicamento: "));
    	
    	Medicamento aux = Operacoes.busca(Medicamento.getIndices(), Medicamento.getDados(), codigo);
    	
    	if (aux != null) {
    		JOptionPane.showMessageDialog(null, aux.toString() + "\nPreço total R$" + (aux.preco * aux.qtdeEstoque));
    	} else {
    		JOptionPane.showMessageDialog(null, "O código não foi encontrado!");
    	}
    }
    
    public static void medicamentosBaixoEstoque() {
    	Predicate<Medicamento> isBaixoEstoque = med -> med.qtdeEstoque < med.qtdEstoqueMinimo;
    	Function<Medicamento, String> stringFinal = med -> med.toString() 
    													   + "\nQtd para comprar: " + (med.qtdEstoqueMinimo - med.qtdeEstoque)
    													   + "\nTotal para comprar: R$" 
    													   + ((med.qtdEstoqueMinimo - med.qtdeEstoque) * med.preco); 
    	    	
    	String todosDados = dados.stream()
					    		.filter(isBaixoEstoque)
					    		.map(stringFinal)
					    		.reduce("", (ac, elem) -> ac.isBlank() ? elem : ac + "\n " + elem)
					    		.toString();
    	
    	if (!todosDados.isBlank()) {
    		JOptionPane.showMessageDialog(null, todosDados);    		
    	} else {
    		JOptionPane.showMessageDialog(null, "Não há medicamentos abaixo do estoque minímo 😎😎😎");    		
    	}
    }
}
