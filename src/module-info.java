module Trabalho_Arquivo_indexado {
    
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires javafx.graphics;
    requires javafx.base;

    opens view;
    opens operacoes;
    opens models;
    opens view.controller; 
}
