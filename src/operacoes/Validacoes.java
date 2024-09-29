package operacoes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

import models.CID;
import models.Cidade;
import models.Consulta;
import models.EspecialidadeMedica;
import models.Medicamento;
import models.Medico;
import models.Paciente;

public class Validacoes {

	// Medico
    protected static boolean validateMedico(int codMedico, int codEspecialidade, int codigoCidade) {
		boolean isNullMedico = Operacoes.busca(Medico.getIndices(), Medico.getDados(), codMedico) == null;
		boolean isNotNullEspecialidade = Operacoes.busca(EspecialidadeMedica.getIndices(), EspecialidadeMedica.getDados(), codEspecialidade) != null;
		boolean isNotNullCidade = Operacoes.busca(Cidade.getIndices(), Cidade.getDados(), codigoCidade) != null;
		
		return isNullMedico && isNotNullEspecialidade && isNotNullCidade;
    }
	
    // Especialidade Medica
    protected static boolean validateEspecialidade(int codigo) {
    	boolean isNullEspecialidade = Operacoes.busca(EspecialidadeMedica.getIndices(),EspecialidadeMedica.getDados(), codigo) == null;
    	return isNullEspecialidade;
    }
    
    // Paciente
    protected static boolean validatePaciente(int codigo, int codigoCidade) {
    	boolean isNullPaciente = Operacoes.busca(Paciente.getIndices(), Paciente.getDados(), codigo) == null;
    	boolean isNotNullCidade = Operacoes.busca(Cidade.getIndices(), Cidade.getDados(), codigoCidade) != null;
    	
    	return isNullPaciente && isNotNullCidade;
    }
    
    public static boolean haveConsulta(Operavel objeto) {
    	
    	if (Consulta.getIndices() != null && !Consulta.getIndices().isEmpty()) {
			for (Consulta consulta : Consulta.getDados()) {
				Operavel aux;
				
				if (objeto instanceof Paciente) {
					aux = consulta.getPaciente();
					if (aux.equals(objeto)) { return true; }					
				}
				
				if (objeto instanceof Medico) {
					aux = consulta.getMedico();
					if (aux.equals(objeto)) { return true; }  
				}	
			}
			return false;
		}
    	return false;
    }
    
    // CID
    protected static boolean validateCID(int codigo) {
    	boolean isNullCID = Operacoes.busca(CID.getIndices(), CID.getDados(), codigo) == null; 
    	return isNullCID;
    }
	
	// Medicamento
    protected static boolean validateMedicamento(int codigo, int qtdEstoque, int qtdMaxima, int qtdMinima, double preco) {
    	boolean isNullMedicamento = Operacoes.busca(Medicamento.getIndices(), Medicamento.getDados(), codigo) == null;
    	Predicate<Integer> checkRangeInt = n -> n >= 0;
    	Predicate<Double> checkRangeDouble = n -> n >= 0.0; 
    	
    	return isNullMedicamento && checkRangeInt.test(qtdEstoque) && checkRangeInt.test(qtdMaxima)
    		   && checkRangeInt.test(qtdMinima) && checkRangeDouble.test(preco);
    } 
    
    protected static boolean validateMedicamento(int quantidadeMedicamento, Medicamento medicamento) {
    	boolean checkEstoque = quantidadeMedicamento <= medicamento.getQtdeEstoque() 
    						&& quantidadeMedicamento > 0;
    						
    	return checkEstoque;
    }
    
    // Cidade
    protected static boolean validateCidade(int codigo) {
    	boolean isNullMedicamento = Operacoes.busca(Cidade.getIndices(), Cidade.getDados(), codigo) == null;
    	
    	return isNullMedicamento;
    }
    
    // Consulta
    protected static boolean validateConsulta(int codigo, int codigoPaciente, int codigoMedico, int codigoCID,
			int codigoMedicamento, int qtdMedicamento) {

		boolean isNullConsulta = Operacoes.busca(Consulta.getIndices(), Consulta.getDados(), codigo) == null;
		boolean isNotNullPaciente = Operacoes.busca(Paciente.getIndices(), Paciente.getDados(), codigoPaciente) != null;
		boolean isNotNullMedico = Operacoes.busca(Medico.getIndices(), Medico.getDados(), codigoMedico) != null;
		boolean isNotNullCID = Operacoes.busca(CID.getIndices(), CID.getDados(), codigoCID) != null;
		boolean isNotNullMedicamento = Operacoes.busca(Medicamento.getIndices(), Medicamento.getDados(), codigoMedicamento) != null;
		boolean checkEstoque;
		
		try {
			 checkEstoque = validateMedicamento(qtdMedicamento, Operacoes.busca(Medicamento.getIndices(), Medicamento.getDados(), codigoMedicamento));
		} catch (Exception e) {
			return false;
		}
		
		return isNullConsulta && isNotNullPaciente && isNotNullMedico && isNotNullCID && isNotNullMedicamento && checkEstoque;
    }
    
	public static boolean validateDataTime(String data, String horario) {
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
		
		try {
			LocalDate.parse(data, formatoData);
			LocalTime.parse(horario, formatoHora);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
