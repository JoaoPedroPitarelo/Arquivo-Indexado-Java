package models;
import java.util.ArrayList;
import java.util.List;

import operacoes.Operavel;

public class Cidade implements Operavel {

    private int codigo;
    private String nome;
    private String UF;
    private int status = 0;
    
    private static List<Cidade> dados = new ArrayList<>();
    private static List<Indice> indices = new ArrayList<>();
    private static int cont;
    
    public Cidade() { }
    
    public static List<Cidade> getDados() { return dados; }
    public static List<Indice> getIndices() { return indices; }
    
    @Override
    public int getCont() { return cont; }
    @Override
    public void setCont(int cont) { Cidade.cont = cont;}
    
    @Override
    public int getCodigo() { return codigo; }
    @Override	
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    @Override
    public int getStatus() { return status; }
    @Override
    public void setStatus(int valor) { this.status = valor >= 0 && valor < 2 ? valor : this.status; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getUF() { return UF;}
    public void setUF(String uf) { UF = uf; }

    @Override
    public String toString() { 
    	return "\nCódigo: " + this.codigo + " " + this.nome + " " + this.UF;
    }
}
