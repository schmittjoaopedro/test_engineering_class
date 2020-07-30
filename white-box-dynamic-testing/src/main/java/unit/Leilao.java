package unit;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

    private String nomeProduto;

    private List<Lance> lances = new ArrayList<>();

    public Leilao(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void propoe(Lance lance) {
        lances.add(lance);
    }

    public List<Lance> getLances() {
        return lances;
    }
}
