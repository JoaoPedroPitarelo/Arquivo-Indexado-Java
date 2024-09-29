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

public class excluirController {

	private Stage stage;
	private Scene scene;
	
	// Botões de excluir.fxml
	@FXML
	private Button btnVoltar;
 	
    @FXML
    private Button btnExcluirMedico;
    @FXML
    private Button btnExcluirPaciente;
    @FXML
    private Button btnReorganizarPaciente;
    
	@FXML
    public void voltarParaPrincipal(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/main.fxml"));
    
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }
	
    @FXML 
    public void excluir(javafx.event.ActionEvent event) throws IOException {
    	Button botao = (Button) event.getSource(); // Capturando o botão
    	String botaoID = botao.getId(); // Capturando o id do botão chamador
    	
    	switch (botaoID) {
		case "btnExcluirMedico":
			Operacoes.excluir(Medico.getIndices(), Medico.getDados(), Leitura.exclusao());
			break;
		case "btnExcluirPaciente":
			Operacoes.excluir(Paciente.getIndices(), Paciente.getDados(), Leitura.exclusao());
			break;
		}
    }
    
    @FXML
    public void reorganizarPaciente(javafx.event.ActionEvent event) throws IOException {
    	Operacoes.reorganizar(Paciente.getIndices(), Paciente.getDados(), new Paciente());
    }
}
