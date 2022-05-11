import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Aluno   {
    private int idAluno;
    private String prontuario;
    private String nome;
    private Curso curso;
    private Cidade cidade;

    public void salvar(){
        PreparedStatement stmt = null;
        Connection conn  = null;

        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "INSERT INTO aluno values (?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,getIdAluno());
            stmt.setString(2,getProntuario());
            stmt.setString(3,getNome());
            stmt.setInt(4,getCurso().getIdCurso());
            stmt.setInt(5, getCidade().getIdCidade());
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(){
        PreparedStatement stmt = null;
        Connection conn  = null;

        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "UPDATE aluno SET prontuario=?, nome=?, curso=?, cidade=? WHERE idAluno=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,getProntuario());
            stmt.setString(2,getNome());
            stmt.setInt(3,getCurso().getIdCurso());
            stmt.setInt(4, getCidade().getIdCidade());
            stmt.setInt(5,getIdAluno());
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagar(){
        PreparedStatement stmt = null;
        Connection conn  = null;

        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "DELETE FROM aluno WHERE idAluno=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,getIdAluno());
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Aluno buscar(int param){
        PreparedStatement stmt = null;
        Connection conn  = null;
        Aluno a=null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM aluno WHERE idAluno=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,param);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = Curso.buscar(rs.getInt("curso"));
                Cidade cidade = Cidade.buscar(rs.getInt("cidade"));
                a = new Aluno(rs.getInt("idAluno"),
                              rs.getString("prontuario"),
                              rs.getString("nome"),
                              curso,cidade);
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public static List<Aluno> buscarTodos(){
        PreparedStatement stmt = null;
        Connection conn  = null;
        List<Aluno> listaAlunos=new ArrayList<>();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM aluno";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = Curso.buscar(rs.getInt("curso"));
                Cidade cidade =  Cidade.buscar(rs.getInt("cidade"));
                Aluno a = new Aluno(rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso,cidade);
                listaAlunos.add(a);
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlunos;
    }

    public void mostrarDados(){
        System.out.println("\n Id: " + getIdAluno() +
                "\n Nome: " + getNome() +
                "\n Prontuario: " + getProntuario()+
                "\n Curso: " + getCurso().getNome() +
                "\n Cidade: " + getCidade().getNome());
    }
    public Aluno(int idAluno, String prontuario, String nome, Curso curso, Cidade cidade) {
        this.idAluno = idAluno;
        this.prontuario = prontuario;
        this.nome = nome;
        this.curso = curso;
        this.cidade = cidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
