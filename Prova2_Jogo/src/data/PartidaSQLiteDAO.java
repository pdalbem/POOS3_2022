package data;

import model.Partida;
import model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaSQLiteDAO implements GenericDAO<Partida,Integer> {
    @Override
    public void salvar(Partida p) {
        String sql = "INSERT INTO partida (dataJogo, time1, time2, placarTime1, placarTime2) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,p.getDataJogo());
            stmt.setInt(2,p.getTime1().getIdTime());
            stmt.setInt(3,p.getTime2().getIdTime());
            stmt.setInt(4,p.getPlacarTime1());
            stmt.setInt(5,p.getPlacarTime2());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Partida partida) {
        String sql = "UPDATE partida SET dataJogo=?, time1=?, time2=?, placarTime1=?, placarTime2=? WHERE idPartida=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,partida.getDataJogo());
            stmt.setInt(2,partida.getTime1().getIdTime());
            stmt.setInt(3,partida.getTime2().getIdTime());
            stmt.setInt(4,partida.getPlacarTime1());
            stmt.setInt(5,partida.getPlacarTime2());
            stmt.setInt(6,partida.getIdPartida());

            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Partida p) {
        String sql = "DELETE FROM partida WHERE idPartida=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,p.getIdPartida());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partida buscar(Integer idPartida) {
        String sql = "SELECT * FROM partida WHERE idPartida=?";
        Partida partida = null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idPartida);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Time time1 = new TimeSQLiteDAO().buscar(rs.getInt("time1"));
                Time time2 = new TimeSQLiteDAO().buscar(rs.getInt("time2"));
                partida = new Partida(rs.getInt("idPartida"),                      rs.getString("dataJogo"),
                        time1,time2,
                        rs.getInt("placarTime1"),
                        rs.getInt("placarTime2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partida;
    }

    @Override
    public List<Partida> buscarTodos() {
        String sql = "SELECT * FROM partida";
        List<Partida> listaPartidas = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Time time1 = new TimeSQLiteDAO().buscar(rs.getInt("time1"));
                Time time2 = new TimeSQLiteDAO().buscar(rs.getInt("time2"));
                Partida partida = new Partida(rs.getInt("idPartida"),
                        rs.getString("dataJogo"),
                        time1,time2,
                        rs.getInt("placarTime1"),
                        rs.getInt("placarTime2"));
                listaPartidas.add(partida);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPartidas;
    }

    public int getLastId() {
        String sql = "SELECT MAX(idPartida) as idPartida FROM partida";
        int id = -1;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idPartida");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
