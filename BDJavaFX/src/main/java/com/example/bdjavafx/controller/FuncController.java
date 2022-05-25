package com.example.bdjavafx.controller;

import com.example.bdjavafx.data.DepartamentoSQLiteDAO;
import com.example.bdjavafx.data.FuncionarioSQLiteDAO;
import com.example.bdjavafx.model.Departamento;
import com.example.bdjavafx.model.Funcionario;
import javafx.beans.property.ReadOnlyStringWrapper;
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

    //estes atributos PRECISAM ter os mesmos nomes
    // do fx:id dos componentes especificados no arquivo FXML  (func-view.fxml).
    @FXML private TextField txtcpffunc;
    @FXML
    private TextField txtnomefunc;
    @FXML private ComboBox<Departamento> comboDepartamento; //comboBox irá armazenar objetos Departamento
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnExcluir;
    @FXML
    private TableView<Funcionario> tblFuncionario;//TableView vai mostrar objetos do tipo Funcionario
    @FXML
    private TableColumn<Funcionario, String> colCPFFunc;
    @FXML
    private TableColumn<Funcionario, String> colNomeFunc;

    ///embora atributo departamento seja da classe Departamento,
    // queremos mostrar na tabela o nome do departamento, que é String.
    // Por isso, a definição de colDepFunc é TableColumn<Funcionario,String>
    @FXML TableColumn<Funcionario,String> colDepFunc;


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
                 comboDepartamento.getValue());//comboBox já retorna objeto departamento, necessário para chamar o construtor de Funcionario
        funcionarioSQLiteDAO.salvar(f);
        preencherTabela();//vai atualizar a tablea após a inserção

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
        //Como a tblFuncionario armazena objetos Funcionario,
        // o comando abaixo já retorna o objeto Funcionario selecionado na tabela pelo usuário
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
        colCPFFunc.setCellValueFactory(new PropertyValueFactory<>("cpf")); //cpf é atributo do model Funcionario
        colNomeFunc.setCellValueFactory(new PropertyValueFactory<>("nome")); //nome é atributo do model Funcionario
        colDepFunc.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getDepartamento().getNome()));

        listView = FXCollections.observableArrayList(new FuncionarioSQLiteDAO().buscarTodos());
        tblFuncionario.setItems(listView);


    }

   public void preencherComboBox(){
       ObservableList<Departamento> listViewDepartamento;
       listViewDepartamento = FXCollections.observableArrayList(new DepartamentoSQLiteDAO().buscarTodos());
       comboDepartamento.setItems(listViewDepartamento);
       //comboDepartamento armazena objetos do tipo Departamento,
       //mas queremos mostrar apenas o nome do departamento.
       //Fzemos isso utilizando o setConverter:
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
