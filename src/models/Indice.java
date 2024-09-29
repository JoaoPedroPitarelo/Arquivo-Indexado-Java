package models;

public class Indice {

    private int codigo;
    private int endereco;
    
    public Indice() {
    	this.codigo = 0;
    	this.endereco = 0;
    }
    
    public Indice(int codigo, int endereco) {
    	this.codigo = codigo;
    	this.endereco = endereco;
    }

	public int getCodigo() { return codigo; }
	public void setCodigo(int codigo) { this.codigo = codigo; }
	
	public int getEndereco() { return endereco; }
	public void setEndereco(int endereco) { this.endereco = endereco; }   
}
