package unit;

import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTest {

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
        Assert.assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        Assert.assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
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
        Assert.assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        Assert.assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
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
        Assert.assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        Assert.assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesUnicoTest() {
        Usuario joao = new Usuario("Joao");
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 300.0));
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        Assert.assertEquals(300.0, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(300.0, leiloeiro.getMenorLance(), 0.0001);
    }
}
