package mock;

import java.util.Calendar;
import java.util.List;

public class EncerradorDeLeilao {

    private LeilaoDao leilaoDao;

    public EncerradorDeLeilao(LeilaoDao leilaoDao) {
        this.leilaoDao = leilaoDao;
    }

    public void encerra() {
        List<Leilao> todosLeiloesCorrentes = leilaoDao.correntes();
        for (Leilao leilao : todosLeiloesCorrentes) {
            if (comecouSemanaPassada(leilao)) {
                leilao.encerra();
                leilaoDao.atualiza(leilao);
            }
        }
    }

    private boolean comecouSemanaPassada(Leilao leilao) {
        return diasEntre(leilao.getData(), Calendar.getInstance()) >= 7;
    }

    private int diasEntre(Calendar inicio, Calendar fim) {
        Calendar data = (Calendar) inicio.clone();
        int diasNoIntervalo = 0;
        while (data.before(fim)) {
            data.add(Calendar.DAY_OF_MONTH, 1);
            diasNoIntervalo++;
        }
        return diasNoIntervalo;
    }

}
