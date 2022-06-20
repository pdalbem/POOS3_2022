package data;

import java.util.List;

public interface GenericDAO<T,K> {
    void  salvar(T type);
    void atualizar (T type);
    void excluir (T type);
    T buscar (K key);
    List<T> buscarTodos();
}
