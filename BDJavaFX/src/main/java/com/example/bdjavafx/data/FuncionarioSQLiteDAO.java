package com.example.bdjavafx.data;

import com.example.bdjavafx.model.Departamento;
import com.example.bdjavafx.model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioSQLiteDAO implements FuncionarioDAO{
    @Override
    public void salvar(Funcionario f) {
        String sql = "INSERT INTO funcionario (cpf,nome, departamento) values (?,?,?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNome());
            stmt.setInt(3,f.getDepartamento().getId());// retorna o id do depto do funcionario, pois chave-estrangeira é int
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Funcionario f) {
        String sql = "UPDATE funcionario SET cpf=?, nome=?, departamento=? WHERE id=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){

            stmt.setString(1,f.getCpf());
            stmt.setString(2,f.getNome());
            stmt.setInt(3,f.getDepartamento().getId());
            stmt.setInt(4,f.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Funcionario f) {
        String sql = "DELETE FROM funcionario WHERE id=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,f.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario buscar(int id) {
        Funcionario f=null;
        String sql = "SELECT * FROM funcionario WHERE id=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento dep = new DepartamentoSQLiteDAO().buscar(rs.getInt("departamento"));
                f = new Funcionario(rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        dep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Funcionario> buscarTodos() {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento dep = new DepartamentoSQLiteDAO().buscar(rs.getInt("departamento"));
                Funcionario f = new Funcionario(rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        dep);
                listaFuncionarios.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFuncionarios;
    }
}

