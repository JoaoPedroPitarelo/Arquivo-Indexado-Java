package models;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.swing.JOptionPane;

import operacoes.Operavel;

public class Consulta implements Operavel {

    private int codigo;
    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private LocalTime horario;
    private CID cid;
    private Medicamento medicamento;
    private int qtdMedicamento;
    static final double precoConsulta = 100.0;
    private int status = 0;
    
    private static List<Consulta> dados = new ArrayList<Consulta>();
    private static List<Indice> indices = new ArrayList<Indice>();
    private static int cont;

    public Consulta( ) { }
  
    public static List<Consulta> getDados() { return dados; }
    public static List<Indice> getIndices() { return indices; }
    
    @Override
    public int getCont() { return cont; }
    @Override
    public void setCont(int cont) { Consulta.cont = cont;}
    
    @Override
    public int getCodigo() { return codigo; }
    @Override	
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    @Override
    public int getStatus() { return status; }
    @Override
    public void setStatus(int valor) { this.status = valor >= 0 && valor < 2 ? valor : this.status; }

	public Paciente getPaciente() { return paciente; }
	public void setPaciente(Paciente paciente) { this.paciente = paciente;}

	public Medico getMedico() { return medico; }
	public void setMedico(Medico medico) { this.medico = medico; }

	public LocalDate getData() { return data; }
	public void setData(LocalDate data) { this.data = data; }

	public LocalTime getHorario() { return horario; }
	public void setHorario(LocalTime horario) { this.horario = horario; }

	public CID getCid() { return cid; }
	public void setCid(CID cid) { this.cid = cid; }

	public Medicamento getMedicamento() { return medicamento; }
	public void setMedicamento(Medicamento medicamento) { this.medicamento = medicamento; }
	
	public int getQtdMedicamento() { return qtdMedicamento; }
	public void setQtdMedicamento(int qtdMedicamento) { this.qtdMedicamento = qtdMedicamento; }
	
	@Override
	public String toString() {
		return "Código: " + codigo
				+ " Paciente: " + paciente.getNome() + " " + paciente.getCidade().toString()
				+ "\nMedico: " + medico.getNome() + " " + medico.getEspecialidade().getDescricao()
				+ "\nCID: " + cid.getDescricao()
				+ "\nMedicamento: " + getMedicamento().getDescricao() + " qtd: " + qtdMedicamento
				+ "\n" + getData() + " às " + getHorario();
	}
    
	public static void totalArrecadado() {
		if (!indices.isEmpty()) {
			Function<Consulta, Double> calculoArrecadacao = 
					consulta -> 100 + (consulta.getMedicamento().getPreco() * consulta.getQtdMedicamento());
					
			double totalArrecado = dados.stream()
										.map(calculoArrecadacao)
										.reduce(0.0, (ac, valor) -> ac + valor);
			
			JOptionPane.showMessageDialog(null, "O total arrecadado em todas as consultas foi: R$" + totalArrecado);
		} else {
			JOptionPane.showMessageDialog(null, "Não há consultas registradas!");
		}						
	}
}
