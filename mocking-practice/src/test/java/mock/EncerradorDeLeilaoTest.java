package mock;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EncerradorDeLeilaoTest {

    @Test
    public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras() {
        Calendar antiga = Calendar.getInstance();
        antiga.set(1999, 1, 20);
        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();
        Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();

        // Simulando a infra-estrutura
        LeilaoDao leilaoDao = new LeilaoDao();
        leilaoDao.salva(leilao1);
        leilaoDao.salva(leilao2);

        EncerradorDeLeilao encerrador = new EncerradorDeLeilao();
        encerrador.encerra();

        // busca no banco a lista de encerrados
        List<Leilao> encerrados = leilaoDao.encerrados();

        // imprime todos registros salvos na base de dados
        leilaoDao.imprimeLeiloes();

        assertEquals(2, encerrados.size());
        assertTrue(encerrados.get(0).isEncerrado());
        assertTrue(encerrados.get(0).isEncerrado());
    }
}