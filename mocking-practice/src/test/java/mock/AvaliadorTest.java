package mock;

import mock.model.Avaliador;
import mock.model.Lance;
import mock.model.Leilao;
import mock.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AvaliadorTest {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario maria;
    private Usuario jose;

    @Before
    public void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("João");
        this.jose = new Usuario("José");
        this.maria = new Usuario("Maria");
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .constroi();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void lancesEmOrdemCrescenteTest() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation 3 Novo")
                .lance(maria, 250.0)
                .lance(joao, 300.0)
                .lance(jose, 400.0)
                .constroi();
        leiloeiro.avalia(leilao);
        // Checando os valores esperados
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesEmOrdemDecrescenteTest() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation 3 Novo")
                .lance(jose, 400.0)
                .lance(joao, 300.0)
                .lance(maria, 250.0)
                .constroi();
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesSemOrdemEspecificaTest() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation 3 Novo")
                .lance(joao, 300.0)
                .lance(jose, 400.0)
                .lance(maria, 250.0)
                .constroi();
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesUnicoTest() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation 3 Novo")
                .lance(joao, 300.0)
                .constroi();
        leiloeiro.avalia(leilao);
        assertEquals(300.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(300.0, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation 3 Novo")
                .constroi();
        leiloeiro.avalia(leilao);
    }
}