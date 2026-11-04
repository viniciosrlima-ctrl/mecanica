package com.senai.mecanica;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tela2Controller {

    @FXML
    private void cadastrarCliente() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("telaCadastroCliente.fxml")
            );

            Parent tela3 = fxmlLoader.load();

            Stage stage = new Stage();

            stage.setScene(new Scene(tela3));

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @FXML
    private void ordenDeServico() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("ordemservico.fxml")
            );

            Parent tela2 = fxmlLoader.load();

            Stage stage = new Stage();

            // Define um tamanho inicial adequado para a tela de Ordem de Serviço.
            // O conteúdo maior fica acessível pela barra de rolagem do ScrollPane.
            stage.setTitle("Ordem de Serviço");
            stage.setScene(new Scene(tela2, 1000, 760));
            stage.setMinWidth(850);
            stage.setMinHeight(600);
            stage.setWidth(1000);
            stage.setHeight(760);
            stage.centerOnScreen();

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @FXML
    private void cadastrarVeiculo() {
        try {


            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("telaCadastroVeiculo.fxml")
            );


            Parent tela2 = fxmlLoader.load();


            Stage stage = new Stage();


            stage.setScene(new Scene(tela2));


            stage.show();


        } catch (Exception e) {


            e.printStackTrace();


        }
    }
}
