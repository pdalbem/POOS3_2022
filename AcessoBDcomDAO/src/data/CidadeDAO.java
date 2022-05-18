package data;

import model.Cidade;

import java.util.List;

public interface CidadeDAO {
    void  salvar(Cidade c);
    void atualizar (Cidade c);
    void excluir (Cidade c);
    Cidade buscar (int codCid);
    List<Cidade> buscarTodos();
}
