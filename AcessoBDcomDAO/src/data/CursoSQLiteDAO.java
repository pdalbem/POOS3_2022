package data;

import model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class CursoSQLiteDAO implements CursoDAO{

    @Override
    public   void salvar(Curso c) {
        String sql = "INSERT INTO curso values (?,?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,c.getIdCurso());
            stmt.setString(2,c.getNome());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Curso c) {
        String sql = "UPDATE curso SET nome=? WHERE idCurso=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,c.getNome());
            stmt.setInt(2,c.getIdCurso());
            stmt.executeUpdate();
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Curso c) {
        String sql = "DELETE FROM curso WHERE idCurso=?";

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,c.getIdCurso());
            stmt.executeUpdate();
        }
       catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Curso buscar(int codCur) {
        String sql = "SELECT * FROM curso WHERE idCurso=?";
        Curso c=null;
       try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
           stmt.setInt(1,codCur);
           ResultSet rs = stmt.executeQuery();
           while (rs.next())
               c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));

       } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Curso> buscarTodos() {
        String sql = "SELECT * FROM curso";
        List<Curso> listaCursos =new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));
                listaCursos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCursos;
    }
}
