import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Curso curso = new Curso("Análise e Desenvolvimento de Sistemas", "ADS");
        AlunoGraduacao alunoGraduacao = new AlunoGraduacao("112233","Maria","SC123456",9,curso,20.0);

        Professor professor = new Professor("123","João", "mestre", "8899");
        AlunoPosGraduacao alunoPosGraduacao = new AlunoPosGraduacao("443322", "José","SC098765",8.5,curso,"machine Learning", professor);

        List<Pessoa> lista = new ArrayList<>();
        lista.add(professor);
        lista.add(alunoGraduacao);
        lista.add(alunoPosGraduacao);

        //Ou assim para criar e adicionar elmentos na lista:
        //List<Pessoa> lista = new ArrayList<>(List.of(professor,alunoGraduacao,alunoPosGraduacao));

        //Polimorfismo: em tempo de execução, JVM verifica qual
        //o tipo do objeto que está na lista e executa o método
        // mostrarDados() apropriado:
        for (Pessoa p : lista)
            p.mostrarDados();
    }
}
