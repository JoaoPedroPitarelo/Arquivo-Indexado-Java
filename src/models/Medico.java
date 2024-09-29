package models;
import java.util.ArrayList;
import java.util.List;

import operacoes.Operavel;

public class Medico implements Operavel {

    private int codigo;
    private String nome;
    private EspecialidadeMedica especialidade;
    private Cidade cidade;
    private int status = 0;

    private static List<Medico> dados = new ArrayList<>();
    private static List<Indice> indices = new ArrayList<>();
    private static int cont;

    public Medico() { }
    
    public static List<Medico> getDados() { return dados; }
    public static List<Indice> getIndices() { return indices; }
    
    @Override
    public int getCont() { return cont; }
    @Override
    public void setCont(int cont) { Medico.cont = cont;}
    
    @Override
    public int getCodigo() { return codigo; }
    @Override	
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    @Override
    public int getStatus() { return status; }
    @Override
    public void setStatus(int valor) { this.status = valor >= 0 && valor < 2 ? valor : this.status; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome;}

    public EspecialidadeMedica getEspecialidade() { return especialidade; }
    public void setEspecialidade(EspecialidadeMedica especialidade) { this.especialidade = especialidade; }

    public Cidade getCidade() { return this.cidade;}
    public void setCidade(Cidade cidade) { this.cidade = cidade; }
        
    @Override
    public String toString() {
    	return "\nCodigo: " + this.codigo + " Nome: " + this.nome + this.getEspecialidade().toString() + this.cidade.toString();
    }
}
