package mock;

public class Pagamento {

    private Long id;

    private Leilao leilao;

    public Pagamento(Leilao leilao) {
        this.leilao = leilao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", leilaoId=" + leilao.getId() +
                ", leilaoNomeProduto='" + leilao.getNomeProduto() + '\'' +
                '}';
    }
}
