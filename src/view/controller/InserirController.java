package view.controller;

import java.io.IOException;

import operacoes.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.*;

public class InserirController {

	private Stage stage;
	private Scene scene;
	 
	@FXML
	private Button btnVoltar;
 	@FXML
    private Button btnInserirCidade;
    @FXML
    private Button btnInserirEspecialidade;
    @FXML
    private Button btnInserirMedicamento;
    @FXML
    private Button btnInserirMedico;
    @FXML
    private Button btnInserirPaciente;
    @FXML
    private Button btnInserirCID;
    @FXML
    private Button btnInserirConsulta;
	 
	@FXML
    public void voltarParaPrincipal(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/main.fxml"));
    
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }
	    
    @FXML 
    public void inserir(javafx.event.ActionEvent event) throws IOException {
    	Button botao = (Button) event.getSource(); 
    	String botaoID = botao.getId(); 
    	
    	switch (botaoID) {
		case "btnInserirCidade": 	
			Operacoes.inserir(Cidade.getIndices(), Cidade.getDados(), Leitura.cidade());
			break;
		case "btnInserirEspecialidade": 
			Operacoes.inserir(EspecialidadeMedica.getIndices(), EspecialidadeMedica.getDados(), Leitura.especialidadeMedica());
			break;
		case "btnInserirMedicamento":
			Operacoes.inserir(Medicamento.getIndices(), Medicamento.getDados(), Leitura.medicamento());
			break;
		case "btnInserirMedico":
			Operacoes.inserir(Medico.getIndices(), Medico.getDados(), Leitura.medico());
			break;
		case "btnInserirPaciente":
			Operacoes.inserir(Paciente.getIndices(), Paciente.getDados(), Leitura.paciente());
			break;
		case "btnInserirCID":
			Operacoes.inserir(CID.getIndices(), CID.getDados(), Leitura.CID());
			break;
		case "btnInserirConsulta":
			Operacoes.inserir(Consulta.getIndices(), Consulta.getDados(), Leitura.consulta());
			break;
		}
    }
}
