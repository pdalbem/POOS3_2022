package com.example.bdjavafx.controller;

import com.example.bdjavafx.data.DepartamentoSQLiteDAO;
import com.example.bdjavafx.model.Departamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DeptoController implements Initializable {
    @FXML private TextField txtnomedepto;
    @FXML private TextField txtsigladepto;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnExcluir;
    @FXML
    private TableView<Departamento> tblDepartamento;
    @FXML
    private TableColumn<Departamento, String> colNomeDepto;
    @FXML
    private TableColumn<Departamento, String> colSiglaDepto;

    ObservableList<Departamento> listView = FXCollections.observableArrayList();

    DepartamentoSQLiteDAO departamentoSQLiteDAO = new DepartamentoSQLiteDAO();
    public void limparCampos(ActionEvent actionEvent) {
        txtnomedepto.clear();
        txtsigladepto.clear();
        txtnomedepto.requestFocus();
        btnNovo.setDisable(true);
        btnSalvar.setDisable(false);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtnomedepto.setEditable(true);
        txtsigladepto.setEditable(true);
    }

    public void salvar(ActionEvent actionEvent) {
        Departamento d = new Departamento(txtnomedepto.getText(),txtsigladepto.getText());
        departamentoSQLiteDAO.salvar(d);
        preencherTabela();

        txtnomedepto.clear();
        txtsigladepto.clear();
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtnomedepto.setEditable(false);
        txtsigladepto.setEditable(false);
    }

    public void atualizar(ActionEvent actionEvent) {
        Departamento d = tblDepartamento.getSelectionModel().getSelectedItem();
        d.setNome(txtnomedepto.getText());
        d.setSigla(txtsigladepto.getText());
        departamentoSQLiteDAO.atualizar(d);
        preencherTabela();
    }
    public void excluir(ActionEvent actionEvent) {
        Departamento d = tblDepartamento.getSelectionModel().getSelectedItem();
        departamentoSQLiteDAO.excluir(d);
        preencherTabela();

        txtnomedepto.clear();
        txtsigladepto.clear();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtnomedepto.setEditable(false);
        txtsigladepto.setEditable(false);

    }

    public void selecionaDepto(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2) {
            Departamento d = tblDepartamento.getSelectionModel().getSelectedItem();
            txtnomedepto.setText(d.getNome());
            txtsigladepto.setText(d.getSigla());

            txtnomedepto.setEditable(true);
            txtsigladepto.setEditable(true);
            btnAtualizar.setDisable(false);
            btnExcluir.setDisable(false);

        }
    }

    public void preencherTabela(){
        listView.clear();
        colNomeDepto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colSiglaDepto.setCellValueFactory(new PropertyValueFactory<>("sigla"));

        listView = FXCollections.observableArrayList(departamentoSQLiteDAO.buscarTodos());
        tblDepartamento.setItems(listView);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preencherTabela();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtnomedepto.setEditable(false);
        txtsigladepto.setEditable(false);
    }


}
