package operacoes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import models.CID;
import models.Cidade;
import models.Consulta;
import models.EspecialidadeMedica;
import models.Medicamento;
import models.Medico;
import models.Paciente;

public class Leitura extends Validacoes {

	private Leitura() {}

	// Cod Exclusão
    public static int exclusao() {
    	
    	try { 
    		while (true) {
    			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código a ser excluído"));
    			
    			if (codigo >= 0) return codigo;
    			
    			JOptionPane.showMessageDialog(null, "Digite um valor maior que 0");
    		}    		
    	} catch (NumberFormatException e) {
    		JOptionPane.showMessageDialog(null, "Operação cancelada...");
			return -1;
    	}
    }
    
    // CID
	public static CID CID() {
    	try {
			CID aux = new CID();
			
			while (true) {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do CID: "));
				String descricao = JOptionPane.showInputDialog("Digite a descrição da CID: Virose, Gripe, Resfriado...");

				if (validateCID(codigo)) {
					aux.setCodigo(codigo);
					aux.setDescricao(descricao);
					break;
				}
				JOptionPane.showMessageDialog(null, "Verifique as credências e tente novamente!");
			}
			return aux;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Operação cancelada...");
			return null;
		} 
    }
	
    // Medicamento
    public static Medicamento medicamento() {
        try {
			Medicamento aux = new Medicamento();
			
			while (true) {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do medicamento: "));
			    String descricao = JOptionPane.showInputDialog("Digite a descrição do medicamento: ");
			    int qtdEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade atual do estoque: "));
			    int qtdMaxima = Integer.parseInt(JOptionPane.showInputDialog("Digite a qtde máxima de " + descricao));
			    int qtdMinima = Integer.parseInt(JOptionPane.showInputDialog("Digite a qtde miníma de " + descricao));
			    double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço unitário do " + descricao));
			    
			    if (validateMedicamento(codigo, qtdEstoque, qtdMaxima, qtdMinima, preco)) {
			    	aux.setCodigo(codigo);
			    	aux.setDescricao(descricao);
			    	aux.setQtdeEstoque(qtdEstoque);
			    	aux.setQtdEstoqueMaximo(qtdMaxima);
			    	aux.setQtdEstoqueMinimo(qtdMinima);
			    	aux.setPreco(preco);
			    	
			    	JOptionPane.showMessageDialog(null, aux.toString());
			    	break;
			    }
			    JOptionPane.showMessageDialog(null, "Verifique as entradas e tente novamente!");
			}
			return aux;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Operação cancelada...");
			return null;
		} 
    }
        
    // Cidade
    public static Cidade cidade() {

    	try {
			Cidade aux = new Cidade();

			while (true) {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da cidade: "));
				String nome = JOptionPane.showInputDialog("Digite o nome da cidade: ");
				String UF = JOptionPane.showInputDialog("Digite o Estado Ex: SP, MG, RJ...").toUpperCase();
				
				if (validateCidade(codigo)) {	
					aux.setCodigo(codigo);
					aux.setNome(nome);
					aux.setUF(UF);
				
					JOptionPane.showMessageDialog(null, aux.toString());
					break;
				}
				 JOptionPane.showMessageDialog(null, "Verifique as entradas e tente novamente!");
			}
			return aux;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Operação cancelada...");
			return null;
		}	
    }
       
    // EspecialidadeMédica
	public static EspecialidadeMedica especialidadeMedica() {
		try {
			EspecialidadeMedica aux = new EspecialidadeMedica();

			while(true) {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da especialidade: "));
				String descricao = JOptionPane.showInputDialog("Digite a descrição da especialidade Ex: Neurologista, Oftamologista..."); 
			
				if (validateEspecialidade(codigo)) {
					aux.setCodigo(codigo);
					aux.setDescricao(descricao);
					
					JOptionPane.showMessageDialog(null, aux.toString());
					break;
				}
				JOptionPane.showMessageDialog(null, "Verifique as entradas e tente novamente!");
			}
			return aux;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Operação cancelada...");
			return null;
		}
	}
		
	// Médico
    public static Medico medico() {
        try {
			Medico aux = new Medico();
			
			while (true) {
			    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do médico: "));
			    aux.setNome(JOptionPane.showInputDialog("Digite o nome: "));
			    int codigoEspecialidade = Integer.parseInt(JOptionPane.showInputDialog("Digite código da especialidade: "));
			    int codigoCidade = Integer.parseInt(JOptionPane.showInputDialog("Digite código da Cidade: "));
			              
			    if (validateMedico(codigo, codigoEspecialidade, codigoCidade)) {	
			    	aux.setCodigo(codigo);
			    	aux.setEspecialidade(Operacoes.busca(EspecialidadeMedica.getIndices(), EspecialidadeMedica.getDados(), codigoEspecialidade));
			    	aux.setCidade(Operacoes.busca(Cidade.getIndices(), Cidade.getDados(), codigoCidade));
			    	
			    	JOptionPane.showMessageDialog(null, aux.toString());
			    	break;
			    } 
			    JOptionPane.showMessageDialog(null, "Verifique as entradas e tente novamente!");
			}
			return aux;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Operação cancelada...");
			return null;
		}
    }
        
    // Paciente
	public static Paciente paciente() {
		try {
			Paciente aux = new Paciente();	
			
			while (true) {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do paciente: "));
			    String nome = JOptionPane.showInputDialog("Digite o nome do paciente: ");
			    String endereco = JOptionPane.showInputDialog("Digite o endereço do paciente: Ex: R. Fulano de tal, 123");
			    int codigoCidade = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da cidade: ")); 
			    
			    if (validatePaciente(codigo, codigoCidade)) {
			    	  aux.setCodigo(codigo);
			          aux.setNome(nome);
			          aux.setEndereco(endereco);
			          aux.setCidade(Operacoes.busca(Cidade.getIndices(), Cidade.getDados(), codigoCidade));
			          
			          JOptionPane.showMessageDialog(null, aux.toString());
			          break;
			    }
			    JOptionPane.showMessageDialog(null, "Verifique as entradas e tente novamente!");
			}
			return aux;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Operação cancelada...");
			return null;
		} 
	}
	
	// Consulta
	public static Consulta consulta() {
		try {
			Consulta aux = new Consulta();
			DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
			DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
			
			while (true) {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da consulta: "));
				int codigoPaciente = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do paciente: "));
				int codigoMedico = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do médico: "));
				String data = JOptionPane.showInputDialog("Digite a data da consulta: (dd/MM/yyyy)");
				String horario = JOptionPane.showInputDialog("Digite o horário da consulta: (HH:mm)");
				int codigoCID = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da CID: "));
				int codigoMedicamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do medicamento: "));
				int qtdMedicamento = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do medicamento: "));
				
				if (validateConsulta(codigo, codigoPaciente, codigoMedico, codigoCID, codigoMedicamento, qtdMedicamento) && validateDataTime(data, horario)) {
					
					Medicamento medicamento = Operacoes.busca(Medicamento.getIndices(), Medicamento.getDados(), codigoMedicamento); 
					medicamento.setQtdeEstoque(medicamento.getQtdeEstoque() - qtdMedicamento);
					
					aux.setCodigo(codigoMedicamento);
					aux.setPaciente(Operacoes.busca(Paciente.getIndices(), Paciente.getDados(), codigoPaciente));
					aux.setMedico(Operacoes.busca(Medico.getIndices(), Medico.getDados(), codigoMedico));
					aux.setData(LocalDate.parse(data, formatoData));
					aux.setHorario(LocalTime.parse(horario, formatoHora));
					aux.setCid(Operacoes.busca(CID.getIndices(), CID.getDados(), codigoCID));
					aux.setMedicamento(medicamento);
					aux.setQtdMedicamento(qtdMedicamento);
				
					JOptionPane.showMessageDialog(null, aux.toString());
					break;
				}
				JOptionPane.showMessageDialog(null, "Verifique as entradas e tente novamente!");
			}
			return aux;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Operação cancelada...");
			return null;
		} 
	}  
}
