package data;

import model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeSQLiteDAO implements GenericDAO<Time,Integer> {
    @Override
    public void salvar(Time t) {
        String sql = "INSERT INTO time (pais) values (?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,t.getPais());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Possivel forma de obter o ID
    //Outra forma está mostrada no final desta classe com o método getLastId()
    public int getIdFromSqlite(String pais){
        int id=-1;
        String sql = "SELECT idTime from time  where pais=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,pais);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idTime");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }

    @Override
    public void atualizar(Time t) {
        String sql = "UPDATE time SET time=? WHERE idTime=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,t.getPais());
            stmt.setInt(2,t.getIdTime());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Time t) {
        String sql = "DELETE FROM time WHERE idTime=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,t.getIdTime());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Time buscar(Integer idTime) {
        String sql = "SELECT * FROM time WHERE idTime=?";
        Time time = null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idTime);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                time = new Time(rs.getInt("idTime"),
                        rs.getString("pais"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public List<Time> buscarTodos() {
        String sql = "SELECT * FROM time";
        List<Time> listaTimes = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Time time = new Time(rs.getInt("idTime"),
                        rs.getString("pais"));
                listaTimes.add(time);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaTimes;
    }

    public int getLastId() {
        String sql = "SELECT MAX(idTime) as idTime FROM time";
        int id = -1;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idTime");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
