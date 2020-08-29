package mock;

import mock.model.Lance;
import mock.model.Leilao;
import mock.model.Usuario;

import java.util.Calendar;

public class CriadorDeLeilao {

    private Leilao leilao;

    public CriadorDeLeilao para(String descricao) {
        this.leilao = new Leilao(descricao);
        return this;
    }

    public CriadorDeLeilao lance(Usuario usuario, double valor) {
        leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public CriadorDeLeilao naData(Calendar data) {
        leilao.setData(data);
        return this;
    }

    public Leilao constroi() {
        return leilao;
    }

}
