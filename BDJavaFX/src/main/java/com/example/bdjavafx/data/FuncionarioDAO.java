package com.example.bdjavafx.data;

import com.example.bdjavafx.model.Funcionario;

import java.util.List;

public interface FuncionarioDAO {
    void  salvar(Funcionario f);
    void atualizar (Funcionario f);
    void excluir (Funcionario f);
    Funcionario buscar (int id);
    List<Funcionario> buscarTodos();
}
