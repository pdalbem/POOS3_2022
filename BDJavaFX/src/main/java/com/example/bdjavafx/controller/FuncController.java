package com.example.bdjavafx.controller;

import com.example.bdjavafx.data.DepartamentoSQLiteDAO;
import com.example.bdjavafx.data.FuncionarioSQLiteDAO;
import com.example.bdjavafx.model.Departamento;
import com.example.bdjavafx.model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class FuncController implements Initializable {

    @FXML private TextField txtcpffunc;
    @FXML
    private TextField txtnomefunc;
    @FXML private ComboBox<Departamento> comboDepartamento;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnExcluir;
    @FXML
    private TableView<Funcionario> tblFuncionario;
    @FXML
    private TableColumn<Funcionario, String> colCPFFunc;
    @FXML
    private TableColumn<Funcionario, String> colNomeFunc;


    ObservableList<Funcionario> listView = FXCollections.observableArrayList();

   FuncionarioSQLiteDAO funcionarioSQLiteDAO = new FuncionarioSQLiteDAO();

    public void limparCampos(ActionEvent actionEvent) {
        btnNovo.setDisable(true);
        btnSalvar.setDisable(false);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtcpffunc.setEditable(true);
        txtnomefunc.setEditable(true);
        comboDepartamento.setDisable(false);
    }

    public void salvar(ActionEvent actionEvent) {

        Funcionario f = new Funcionario(txtcpffunc.getText(),
                                        txtnomefunc.getText(),
                 comboDepartamento.getValue());
        funcionarioSQLiteDAO.salvar(f);
        preencherTabela();

        txtcpffunc.clear();
        txtnomefunc.clear();
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtcpffunc.setEditable(false);
        txtcpffunc.setEditable(false);
        comboDepartamento.setDisable(true);

    }

    public void atualizar(ActionEvent actionEvent) {
        Funcionario f =  tblFuncionario.getSelectionModel().getSelectedItem();
        f.setCpf(txtcpffunc.getText());
        f.setNome(txtnomefunc.getText());
        f.setDepartamento(comboDepartamento.getValue());
        funcionarioSQLiteDAO.atualizar(f);
        preencherTabela();
    }

    public void excluir(ActionEvent actionEvent) {
        Funcionario f = tblFuncionario.getSelectionModel().getSelectedItem();
        funcionarioSQLiteDAO.excluir(f);
        preencherTabela();

        txtcpffunc.clear();
        txtnomefunc.clear();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtcpffunc.setEditable(false);
        txtnomefunc.setEditable(false);
    }

    public void selecionaFunc(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2) {
            Funcionario f = tblFuncionario.getSelectionModel().getSelectedItem();
            txtcpffunc.setText(f.getCpf());
            txtnomefunc.setText(f.getNome());

            txtcpffunc.setEditable(true);
            txtnomefunc.setEditable(true);
            comboDepartamento.setDisable(false);
            btnAtualizar.setDisable(false);
            btnExcluir.setDisable(false);

        }
    }

    public void preencherTabela(){
        listView.clear();
        colCPFFunc.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colNomeFunc.setCellValueFactory(new PropertyValueFactory<>("nome"));


        listView = FXCollections.observableArrayList(new FuncionarioSQLiteDAO().buscarTodos());
        tblFuncionario.setItems(listView);


    }

   public void preencherComboBox(){
       ObservableList<Departamento> listViewDepartamento;
       listViewDepartamento = FXCollections.observableArrayList(new DepartamentoSQLiteDAO().buscarTodos());
       comboDepartamento.setItems(listViewDepartamento);
       comboDepartamento.setConverter(new StringConverter<>() {
           @Override
           public String toString(Departamento d) {
               if (d!=null)
                   return d.getNome();
               return null;
           }

           @Override
           public Departamento fromString(String s) {
               return null;
           }
       });
   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preencherTabela();
        preencherComboBox();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtcpffunc.setEditable(false);
        txtnomefunc.setEditable(false);
        comboDepartamento.setDisable(true);
    }
}
