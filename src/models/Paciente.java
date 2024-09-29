package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import operacoes.Operavel;

public class Paciente implements Operavel {

    private int codigo;
    private String nome;
    private String endereco;
    private Cidade cidade;
    private int status = 0;
    
    private static List<Paciente> dados = new ArrayList<>();
    private static List<Indice> indices = new ArrayList<>();
    private static int cont;
    
    public Paciente() { }
    
    public static List<Paciente> getDados() { return dados; }
    public static List<Indice> getIndices() { return indices; }
    
    @Override
    public int getCont() { return cont; }
    @Override
    public void setCont(int cont) { Paciente.cont = cont;}
    
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

	public String getEndereco() { return endereco; }
	public void setEndereco(String endereco) { this.endereco = endereco; }

	public Cidade getCidade() { return cidade; }
	public void setCidade(Cidade cidade) { this.cidade = cidade; }
		   
	@Override
    public String toString() { 
    	return "\nCodigo: " + this.codigo  + " Nome: " + this.nome
    			+ "\nCidade: " + this.cidade.getNome() + " " + this.cidade.getUF();
    }

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return codigo == other.codigo;
	}
}
