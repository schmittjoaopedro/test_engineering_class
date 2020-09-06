package mock;

import static org.mockito.Mockito.*;
import org.junit.Test;

import java.util.Arrays;
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

        // Criando o mock
        LeilaoDao leilaoDao = mock(LeilaoDao.class);
        // Ensinando o mock a reagir da forma que esperamos
        List<Leilao> leiloesAntigos = Arrays.asList(leilao1, leilao2);
        when(leilaoDao.correntes()).thenReturn(leiloesAntigos);
        when(leilaoDao.encerrados()).thenReturn(leiloesAntigos);

        EncerradorDeLeilao encerrador = new EncerradorDeLeilao(leilaoDao);
        encerrador.encerra();

        // busca no banco a lista de encerrados
        List<Leilao> encerrados = leilaoDao.encerrados();

        // verificando que a atualiza��o foi chamada
        verify(leilaoDao).atualiza(leilao1);
        verify(leilaoDao).atualiza(leilao2);

        assertEquals(2, encerrados.size());
        assertTrue(encerrados.get(0).isEncerrado());
        assertTrue(encerrados.get(1).isEncerrado());

        // imprime todos registros salvos na base de dados
        leilaoDao.imprimeBase();

    }
}