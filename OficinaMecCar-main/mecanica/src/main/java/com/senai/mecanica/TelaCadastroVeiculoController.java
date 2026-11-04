package com.senai.mecanica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class TelaCadastroVeiculoController {

    @FXML
    private TextField placaFx;
    @FXML
    private TextField anoFx;
    @FXML
    private TextField corFx;
    @FXML
    private TextField modeloFx;
    @FXML
    private TextField quilometragemFx;
    @FXML
    private TextField historicoDemanutencaoFx;
    @FXML
    private Label mensagemFx;

    @FXML
    public void initialize() {
        aplicarMascaraPlaca();
        aplicarMascaraAno();
        aplicarMascaraQuilometragem();
    }

    /**
     * Formata a placa para letras maiúsculas e aceita apenas letras e números (máx 7 caracteres)
     */
    private void aplicarMascaraPlaca() {
        placaFx.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) return;

            // Remove tudo que não for letra ou número e converte para maiúsculo
            String limpo = newValue.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

            // Limita a 7 caracteres (padrão brasileiro/Mercosul)
            if (limpo.length() > 7) {
                limpo = limpo.substring(0, 7);
            }

            if (!newValue.equals(limpo)) {
                placaFx.setText(limpo);
            }
        });
    }

    /**
     * Limita o campo ano a no máximo 4 dígitos numéricos
     */
    private void aplicarMascaraAno() {
        anoFx.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) return;

            // Mantém apenas dígitos
            String apenasNumeros = newValue.replaceAll("[^0-9]", "");

            // Limita a 4 dígitos
            if (apenasNumeros.length() > 4) {
                apenasNumeros = apenasNumeros.substring(0, 4);
            }

            if (!newValue.equals(apenasNumeros)) {
                anoFx.setText(apenasNumeros);
            }
        });
    }

    /**
     * Formata o campo de quilometragem com separador de milhar (ex: 100.000)
     */
    private void aplicarMascaraQuilometragem() {
        quilometragemFx.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.isEmpty()) return;

            // Remove tudo que não for dígito
            String apenasNumeros = newValue.replaceAll("[^0-9]", "");

            if (apenasNumeros.isEmpty()) {
                quilometragemFx.setText("");
                return;
            }

            try {
                // Converte para número e aplica a formatação pt-BR (separador por ponto)
                long valor = Long.parseLong(apenasNumeros);
                NumberFormat formatador = NumberFormat.getInstance(new Locale("pt", "BR"));
                String formatado = formatador.format(valor);

                if (!newValue.equals(formatado)) {
                    quilometragemFx.setText(formatado);
                }
            } catch (NumberFormatException e) {
                quilometragemFx.setText(oldValue);
            }
        });
    }

    @FXML
    public void salvarVeiculo() {
        String placa = placaFx.getText();
        String ano = anoFx.getText();
        String cor = corFx.getText();
        String modelo = modeloFx.getText();
        String quilometragem = quilometragemFx.getText();
        String historico = historicoDemanutencaoFx.getText();

        // Limpa os campos após salvar
        placaFx.clear();
        anoFx.clear();
        corFx.clear();
        modeloFx.clear();
        quilometragemFx.clear();
        historicoDemanutencaoFx.clear();

        // Mensagem de sucesso
        mensagemFx.setText("Cadastro realizado com sucesso!");
    }

    @FXML
    private void voltarTela2(ActionEvent event) {
        try {
            Parent tela2 = FXMLLoader.load(getClass().getResource("tela2.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(tela2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}