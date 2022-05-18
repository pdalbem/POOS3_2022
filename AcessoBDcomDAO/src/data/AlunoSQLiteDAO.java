package data;

import model.Aluno;
import model.Cidade;
import model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoSQLiteDAO implements AlunoDAO{
    @Override
    public void salvar(Aluno a) {
        String sql = "INSERT INTO aluno values (?,?,?,?,?)";

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,a.getIdAluno());
            stmt.setString(2,a.getProntuario());
            stmt.setString(3,a.getNome());
            stmt.setInt(4,a.getCurso().getIdCurso());
            stmt.setInt(5, a.getCidade().getIdCidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Aluno a) {

        String sql = "UPDATE aluno SET prontuario=?, nome=?, curso=?, cidade=? WHERE idAluno=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,a.getProntuario());
            stmt.setString(2,a.getNome());
            stmt.setInt(3,a.getCurso().getIdCurso());
            stmt.setInt(4, a.getCidade().getIdCidade());
            stmt.setInt(5,a.getIdAluno());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Aluno a) {
        String sql = "DELETE FROM aluno WHERE idAluno=?";

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,a.getIdAluno());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aluno buscar(String prontuario) {
        String sql = "SELECT * FROM aluno WHERE prontuario=?";
        Aluno a=null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,prontuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new CursoSQLiteDAO().buscar(rs.getInt("curso"));
                Cidade cidade = new CidadeSQLiteDAO().buscar(rs.getInt("cidade"));
                a = new Aluno(rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso,cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Aluno> buscarTodos() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> listaAlunos=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new CursoSQLiteDAO().buscar(rs.getInt("curso"));
                Cidade cidade = new CidadeSQLiteDAO().buscar(rs.getInt("cidade"));
                Aluno a = new Aluno(rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso,cidade);
                listaAlunos.add(a);
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlunos;
    }
}
