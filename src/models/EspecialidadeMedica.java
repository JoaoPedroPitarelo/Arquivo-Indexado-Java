package models;

import java.util.ArrayList;
import java.util.List;

import operacoes.Operavel;

public class EspecialidadeMedica implements Operavel {

    private int codigo;
    private String descricao;
    private int status = 0;

    private static List<EspecialidadeMedica> dados = new ArrayList<>();
    private static List<Indice> indices = new ArrayList<>();
    private static int cont;
    
    public EspecialidadeMedica() { }

    public static List<EspecialidadeMedica> getDados() { return dados; }
    public static List<Indice> getIndices() { return indices; }
    
    @Override
    public int getCont() { return cont; }
    @Override
    public void setCont(int valor) { cont = valor; }
    
    @Override
    public int getStatus() { return this.status; }
    @Override
    public void setStatus(int valor) { this.status = valor >= 0 && valor < 2 ? valor : this.status; }
    
    @Override
    public int getCodigo() { return codigo; }
    @Override
    public void setCodigo(int codigoEspecialidade) { this.codigo = codigoEspecialidade; }
   
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    @Override
    public String toString() { 
    	return "\nCodigo: " + this.codigo  + " Descrição: " + this.descricao;
    }
}
