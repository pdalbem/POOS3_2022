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
    //estes atributos PRECISAM ter os mesmos nomes
    // do fx:id dos componentes especificados no arquivo FXML  (depto-view.fxml).
    @FXML private TextField txtnomedepto;
    @FXML private TextField txtsigladepto;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnExcluir;
    @FXML
    private TableView<Departamento> tblDepartamento; //TableView vai mostrar objetos do tipo Departamento
    @FXML
    private TableColumn<Departamento, String> colNomeDepto;
    @FXML
    private TableColumn<Departamento, String> colSiglaDepto;

    //listView que irá armazenar os departamentos cadastrados no BD.
    //Depois, basta indicar que a tabela irá apresentar os dados armazenados nesta listView (veja método preencherTabela())
    //A lista precisa ser deste tipo ObservableList,senão a TableView não consegue apresentar os elementos contidos nela
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
        //Construtor é chamado passando os valores digitados nos TextFields
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
        //Como a tblDepartamento armazena objetos Departamento,
        // o comando abaixo já retorna o objeto Departamento selecionado na tabela pelo usuário
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
        //Utilizamos uma fábrica de células/cólunas para associar cada coluna com um atributo da classe Departamento.
        // Repare que a string passada para o PropertyValueFactory é o nome
        // do atributo da classe Departamento que desejamos mostrar na tabela.
        colNomeDepto.setCellValueFactory(new PropertyValueFactory<>("nome"));//nome é atributo do model Departamento
        colSiglaDepto.setCellValueFactory(new PropertyValueFactory<>("sigla"));//sigla é atributo do model Departamento

        listView = FXCollections.observableArrayList(departamentoSQLiteDAO.buscarTodos());
        tblDepartamento.setItems(listView);
    }


    //método que será executado quando a tela/janela abrir
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
