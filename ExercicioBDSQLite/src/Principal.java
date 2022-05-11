import java.util.List;

public class Principal {
    public static void main(String[] args) {
         Curso curso = new Curso(100,"Java");
         curso.salvar();

         Cidade cidade = new Cidade(1, "São  Carlos");
         cidade.salvar();

        Aluno aluno = new Aluno(1,"12345","Maria",curso, cidade);
        aluno.salvar();

        List<Aluno> listaAlunos;
        listaAlunos=Aluno.buscarTodos();
        for  (Aluno a : listaAlunos)
             a.mostrarDados();

    }
}
