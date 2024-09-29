package view.controller;

import java.io.IOException;

import models.*;
import operacoes.Operacoes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConsultarController {

	private Stage stage;
	private Scene scene;
	
	@FXML
	private Button btnVoltar;
 	@FXML
    private Button btnConsultarCidade;
    @FXML
    private Button btnConsultarEspecialidade;
    @FXML
    private Button btnConsultarMedicamento;
    @FXML
    private Button btnConsultarMedico;
    @FXML
    private Button btnConsultarPaciente;
    @FXML
    private Button btnConsultarCID;
    @FXML
    private Button btnConsultarConsulta;
    @FXML
    private Button btnConsultarBaixoEstoque;
	@FXML
	private Button btnConsultarTotalArrecadado;
	
	@FXML
    public void voltarParaPrincipal(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/main.fxml"));
    
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }
	
	@FXML
	public void consultar(javafx.event.ActionEvent event) throws IOException {
		Button botao = (Button) event.getSource();
		String botaoID = botao.getId();
		
		switch (botaoID) {
		case "btnConsultarCidade": 	
			Operacoes.imprimirDados(Cidade.getDados());
			break;
		case "btnConsultarEspecialidade": 
			Operacoes.imprimirDados(EspecialidadeMedica.getDados());
			break;
		case "btnConsultarMedicamento":
			Medicamento.consultarMedicamento();
			break;
		case "btnConsultarBaixoEstoque":
			Medicamento.medicamentosBaixoEstoque();
			break;
		case "btnConsultarMedico":
			Operacoes.imprimirDados(Medico.getDados());
			break;
		case "btnConsultarPaciente":
			Operacoes.imprimirDados(Paciente.getDados());
			break;
		case "btnConsultarCID":
			Operacoes.imprimirDados(CID.getDados());
			break;
		case "btnConsultarConsulta":
			Operacoes.imprimirDados(Consulta.getDados());
			break;
		case "btnConsultarTotalArrecadado":
			Consulta.totalArrecadado();
			break;
		}
	}
	
}
