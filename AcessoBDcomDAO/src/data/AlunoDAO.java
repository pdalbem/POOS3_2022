package data;

import model.Aluno;
import java.util.List;

public interface AlunoDAO {
    void  salvar(Aluno a);
    void atualizar (Aluno a);
    void apagar (Aluno a);
    Aluno buscar (String prontuario);
    List<Aluno> buscarTodos();
}
