/**
 * Execute a peer-review in this code following the rules below:
 * - Prompting improvements in source code
 * - Justifying why this should be improved
 */


public class CalculadoraMercadoAcoes {

    public static void main(String[] args) {
        String[] v1 = {"MGLU3", "ITSA3", "LWSA3", "WEGE3", "CNTO3"};
        double[] v2 = {83.29, 12.38, 46.92, 68.00, 29.50};
        double[] v3 = {94.58, 10.94, 59.84, 67.19, 30.44};
        melComp(v1, v2, v3);
    }

    static void melComp(String[] nms, double[] v1, double[] v2) {
        String[][] g = new String[nms.length][2];
        for (int i = 0; i < nms.length; i++) {
            g[i][0] = nms[i];
            g[i][1] = "" + (v2[i] - v1[i]);
        }
        double pr = -1000000;
        String nm = "Not found";
        for (int i = 0; i < g.length; i++) {
            if (Double.parseDouble(g[i][1]) > pr) {
                pr = Double.parseDouble(g[i][1]);
                nm = g[i][0];
            }
        }
        System.out.println("Compre " + nm + " porque o ultimo preco foi de: " + pr);
    }

}