import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int idCurso;
    private String nome;

    public void salvar(){
        PreparedStatement stmt = null;
        Connection conn  = null;

        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "INSERT INTO curso values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,getIdCurso());
            stmt.setString(2,getNome());
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
            String sql = "UPDATE curso SET nome=? WHERE idCurso=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,getNome());
            stmt.setInt(2,getIdCurso());
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
            String sql = "DELETE FROM curso WHERE idCurso=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,getIdCurso());
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Curso buscar(int param){
        PreparedStatement stmt = null;
        Connection conn  = null;
        Curso c=null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM curso WHERE idCurso=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,param);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static List<Curso> buscarTodos(){
        PreparedStatement stmt = null;
        Connection conn  = null;
        List<Curso> listaCursos =new ArrayList<>();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM curso";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));
                listaCursos.add(c);
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCursos;
    }

    public void mostrarDados(){
        System.out.println("\n Id: " + getIdCurso() +
                "\n Nome: " + getNome());
    }
    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
