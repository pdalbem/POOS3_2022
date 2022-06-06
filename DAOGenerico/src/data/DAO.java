package data;

import model.Aluno;

import java.util.List;

public interface DAO <T,K>{
    void  salvar(T type);
    void atualizar (T type);
    void apagar (T type);
    T buscar (K key);
    List<T> buscarTodos();
}
