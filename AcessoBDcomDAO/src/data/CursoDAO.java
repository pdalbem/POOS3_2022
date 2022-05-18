package data;

import model.Curso;

import java.util.List;

public interface CursoDAO {
     void  salvar(Curso c);

     void atualizar (Curso c);
     void excluir (Curso c);
     Curso buscar (int codCur);
     List<Curso> buscarTodos();
}
