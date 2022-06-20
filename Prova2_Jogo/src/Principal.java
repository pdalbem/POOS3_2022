import data.PartidaSQLiteDAO;
import data.TimeSQLiteDAO;
import model.Partida;
import model.Time;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        TimeSQLiteDAO timeSQLiteDAO = new TimeSQLiteDAO();
        Time time1 = new Time("Brasil"); //o OBJETO possui idTime=0
        timeSQLiteDAO.salvar(time1); //SQLite atribui Id automaticamente
        int id = timeSQLiteDAO.getIdFromSqlite(time1.getPais()); //Verifico qual ID foi atribuído pelo SQLite
        time1.setIdTime(id); //Faça OBJETO ter o Id igual ao que foi atribuído pelo BD

        Time time2 = new Time("França");
        timeSQLiteDAO.salvar(time2);
        id = timeSQLiteDAO.getIdFromSqlite(time2.getPais());
        time2.setIdTime(id);


        PartidaSQLiteDAO partidaSQLiteDAO = new PartidaSQLiteDAO();
        Partida partida1 = new Partida("14/jun",time1,time2);//veja o construtor. Placa está 0X0
        partidaSQLiteDAO.salvar(partida1);
        partida1.setIdPartida(partidaSQLiteDAO.getLastId());

        partida1.atualizarPlacar(3,1); //atualizo o placar no OBJETO
        partidaSQLiteDAO.atualizar(partida1); //atualizo o registro no BD

        List<Time> listaTimes = timeSQLiteDAO.buscarTodos();
        for (Time t : listaTimes )
           t.mostrarDados();

        List<Partida> listaPartidas = partidaSQLiteDAO.buscarTodos();
        for (Partida p : listaPartidas )
            p.mostrarDados();
    }
}
