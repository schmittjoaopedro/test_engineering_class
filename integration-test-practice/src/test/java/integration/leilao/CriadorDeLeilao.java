package integration.leilao;

import java.util.Calendar;

public class CriadorDeLeilao {

    private Leilao leilao;

    public CriadorDeLeilao para(String descricao) {
        this.leilao = new Leilao(descricao);
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
