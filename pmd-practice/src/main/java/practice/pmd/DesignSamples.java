package practice.pmd;

public class DesignSamples {

    private int t;

    private boolean d;

    private boolean k;

    public DesignSamples(int t, boolean d, boolean k) {
        this.t = t;
        this.d = d;
        this.k = k;
    }

    public boolean bar(int a, int b) {
        if (!(a == b)) {
            return false;
        }
        return true;
    }

    public int highCyclo() {
        int x = 0;
        if (t < 5) {
            if (t < 10 && d) {
                x = 1;
            } else {
                x = 2;
            }
        } else if (t < 10) {
            if (d) {
                if (t < 7) {
                    x = 3;
                } else if (t < 8) {
                    if (k) {
                        x = 4;
                    } else {
                        x = 10;
                    }
                } else {
                    x = 5;
                }
            } else {
                x = 6;
            }
        } else {
            if (d) {
                if (k) {
                    x = 7;
                } else {
                    x = 9;
                }
            } else if (k) {
                x = 10;
            } else {
                x = 9;
            }
        }
        return x;
    }

}
