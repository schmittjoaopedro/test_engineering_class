package practice.pmd;

public class PerformanceSamples {

    public String bar() {
        String a;
        a = "foo";
        a += " bar";
        return a;
    }

    public int returnIndex(String s) {
        return s.indexOf("d");
    }

}
