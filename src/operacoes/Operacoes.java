package operacoes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import models.Indice;
import models.Medico;
import models.Paciente;

public class Operacoes {

	private Operacoes() {}
	
	// Busca binária ----
	public static <T extends Operavel> T busca(List<Indice> indices, List<T> dados, int codigoBuscado) {
	   
		int inicio = 0;
	    int fim = dados.size() - 1;

	    while (inicio <= fim) {
	        int meio = (inicio + fim) / 2;

	        if (indices.get(meio).getCodigo() == codigoBuscado) {
	            if (dados.get(indices.get(meio).getEndereco()).getStatus() == 0) {
	                return dados.get(indices.get(meio).getEndereco());
	            }
	            return null; 
	        }

	        if (codigoBuscado > indices.get(meio).getCodigo()) {
	            inicio = meio + 1;
	        } else {
	            fim = meio - 1;
	        }
	    }
	    return null; 
	}
	
	// Inserção ----
	private static <T extends Operavel> void primeiraInsercao(List<Indice> indices, List<T> dados, T objeto) {
		indices.add(new Indice(objeto.getCodigo(), 0));
		dados.add(objeto);
		objeto.setCont(objeto.getCont() +1);
	}
	
    public static <T extends Operavel> void inserir(List<Indice> indices, List<T> dados, T objeto) { 	
    	try {
			int i = 0;
			
			if (!indices.isEmpty()) {
				
				dados.add(objeto);
				indices.add(new Indice());
				
				for (i = objeto.getCont() -1; i >= 0 && indices.get(i).getCodigo() > dados.get(objeto.getCont()).getCodigo(); i--) {
					indices.set(i +1, indices.get(i));
				}
				
				indices.set(i +1, new Indice(objeto.getCodigo(), dados.size() -1));
				objeto.setCont(objeto.getCont() +1);
			} else {
				primeiraInsercao(indices, dados, objeto);
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "O Objeto não pode ser NULO! \n");
		}
    }
    
    // Exclusão lógica
    public static <T extends Operavel> void excluir(List<Indice> indices, List<T> dados, int codigo) {
    	Operavel aux = busca(indices, dados, codigo);
    	
    	if (aux != null) {
    		
    		if (aux instanceof Paciente) {
				if (Validacoes.haveConsulta((Paciente) aux)) {
					JOptionPane.showMessageDialog(null, "O paciente não pode ser excluído pois tem consulta agendada!");
					return;
				}    				
    		}
    		
    		if (aux instanceof Medico) {
				if (Validacoes.haveConsulta((Medico) aux)) {
					JOptionPane.showMessageDialog(null, "O médico não pode ser excluído pois tem consulta agendada!");
					return;
				}    				
    		}
    			
    		aux.setStatus(1);
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");	
    	} else {
    		JOptionPane.showMessageDialog(null, "Código não Encontrado!");
    	}
    }
    
    // Impressão ----
    public static void imprimirIndices(List<Indice> indices) {
    	System.out.println("Código Endereço"); 
    	indices.stream().forEach(indice -> System.out.println("  " + indice.getCodigo() + "       " + indice.getEndereco()));
    }
    
    public static <T extends Operavel> void imprimirDados(List<T> dados) {
    	Predicate<T> notExcluido = obj -> obj.getStatus() != 1;
    	
    	dados.stream()
    		.filter(notExcluido)
    		.forEach(obj -> imprimirAtributos(obj));
    }
    
    	// Usando reflection
    private static <T> void imprimirAtributos(T objeto) {
        Class<?> classe = objeto.getClass();
        Field[] campos = classe.getDeclaredFields();
        
        StringBuilder atributosConcatenados = new StringBuilder();
        atributosConcatenados.append("Classe: ").append(classe.getSimpleName()).append("\n\n");
        
        for (Field campo : campos) {
            campo.setAccessible(true);  
 
            if (campo.getName().equals("dados") ||
            	campo.getName().equals("indices") || 
            	campo.getName().equals("cont") ||
            	campo.getName().equals("status")) {
                continue;
            }

            try {
                atributosConcatenados.append(campo.getName())
                                     .append(": ")
                                     .append(campo.get(objeto))
                                     .append("\n");
            } catch (IllegalAccessException e) {
                atributosConcatenados.append("Não foi possível acessar o valor do campo: ")
                                     .append(campo.getName())
                                     .append("\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, atributosConcatenados.toString());
    }


	public static <T extends Operavel> void reorganizar(List<Indice> indices, List<T> dados, T obj) {
		
		if(indices.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há dados para serem reorganizado!");
			return;
		}
		
		List<T> dadosAux = new ArrayList<T>();
		List<Indice> indicesAux = new ArrayList<Indice>();
		
		int novoContador = 0;
		int endereco;
		
		for (int i = 0; i < obj.getCont(); i++) {
			
			endereco = indices.get(i).getEndereco();
			
			if (dados.get(endereco).getStatus() == 0) {
				
				dadosAux.add(novoContador, dados.get(endereco));
				
				// Adicionando novo índice
				indicesAux.add(new Indice());
				indicesAux.getLast().setCodigo(dadosAux.get(novoContador).getCodigo());
				indicesAux.getLast().setEndereco(novoContador);
				
				novoContador++;
			}
		}
		
		for (int i = 0; i < novoContador; i++) {
			
			dados.set(i, dadosAux.get(i));
			indices.set(i, indicesAux.get(i));
		}
		
		obj.setCont(novoContador);
		
	    while (dados.size() > novoContador) {
	        dados.remove(dados.size() - 1);
	    }
	    while (indices.size() > novoContador) {
	        indices.remove(indices.size() - 1);
	    }
	    
	    JOptionPane.showMessageDialog(null, "Reorganização realizado com sucesso!");
	}
}
