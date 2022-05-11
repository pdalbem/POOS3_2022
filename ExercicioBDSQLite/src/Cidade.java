import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private int idCidade;
    private String nome;

    public void salvar(){
        PreparedStatement stmt = null;
        Connection conn  = null;

        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "INSERT INTO cidade values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,getIdCidade());
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
            String sql = "UPDATE cidade SET nome=? WHERE idCidade=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,getNome());
            stmt.setInt(2,getIdCidade());
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
            String sql = "DELETE FROM cidade WHERE idCidade=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,getIdCidade());
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Cidade buscar(int param){
        PreparedStatement stmt = null;
        Connection conn  = null;
        Cidade c=null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM cidade WHERE idCidade=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,param);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                c = new Cidade(rs.getInt("idCidade"), rs.getString("nome"));

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static List<Cidade> buscarTodos(){
        PreparedStatement stmt = null;
        Connection conn  = null;
        List<Cidade> listaCursos =new ArrayList<>();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM cidade";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cidade c = new Cidade(rs.getInt("idCidade"), rs.getString("nome"));
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
        System.out.println("\n Id: " + getIdCidade() +
                "\n Nome: " + getNome());
    }

    public Cidade(int idCidade, String nome) {
        this.idCidade = idCidade;
        this.nome = nome;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
