/**
 * Execute a peer-review in this code following the rules below:
 * - Prompting improvements in source code
 * - Justifying why this should be improved
 */


public class StockMarket {

    public void analyzeMarket(String[] actives) {
        String[][] gains = new String[actives.length][2];
        for (int i = 0; i < actives.length; i++) {
            StockProduct sp = new StockProduct();
            sp.n = actives[i];
            sp.time_period = 7;
            gains[i][0] = sp.n;
            gains[i][1] = sp.calcGain();
        }
        double best_p = -1000000;
        String best_n = "Not found";
        for (int i = 0;i < gains.length; i++) {
            if (Double.parseDouble(gains[i][1]) > best_p) {
                best_p = Double.parseDouble(gains[i][1]);
                best_n = gains[i][0];
            }
        }
        System.out.println("Buy " + best_n + " because the gain was " + best_p);
    }

}

class StockProduct {

    String n;

    double time_period;

    double price1;

    double price2;

    public double calcGain() {
        StockAPI api = new StockAPI();
        StockResponse response = api.getPrices(n, time_period);
        price1 = response.getStartPrice();
        price2 = response.getLastPrice();
        double g = price2 - price1;
        return g;
    }

}