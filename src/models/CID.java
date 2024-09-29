package models;
import java.util.ArrayList;
import java.util.List;

import operacoes.Operavel;

public class CID implements Operavel {

    private int codigo;
    private String descricao;
    private int status = 0;
    
    private static List<CID> dados = new ArrayList<>();
    private static List<Indice> indices = new ArrayList<>();
    private static int cont;

    public CID() { }
    
    public static List<CID> getDados() { return dados; }
    public static List<Indice> getIndices() { return indices; }
    
    @Override
    public int getCont() { return cont; }
    @Override
    public void setCont(int cont) { CID.cont = cont; }
    
    @Override
    public int getCodigo() { return codigo; }
    @Override
 	public void setCodigo(int codigo) { this.codigo = codigo;}
    
    @Override
    public int getStatus() { return status; }
    @Override
    public void setStatus(int valor) { this.status = valor >= 0 && valor < 2 ? valor : this.status; }

 	public String getDescricao() { return descricao; }

 	public void setDescricao(String descricao) { this.descricao = descricao; }
   
    @Override
    public String toString() { 
    	return "\nCodigo: " + this.codigo  + " Descrição: " + this.descricao;
    }
}
