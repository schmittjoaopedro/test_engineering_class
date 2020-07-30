package unit;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AvaliadorTest {

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void lancesEmOrdemCrescenteTest() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(maria, 250.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        // Checando os valores esperados
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesEmOrdemDecrescenteTest() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 250.0));
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesSemOrdemEspecificaTest() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 250.0));
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesUnicoTest() {
        Usuario joao = new Usuario("Joao");
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 300.0));
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(300.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(300.0, leiloeiro.getMenorLance(), 0.0001);
    }
}
