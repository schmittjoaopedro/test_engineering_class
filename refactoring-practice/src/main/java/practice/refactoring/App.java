package practice.refactoring;

public final class App {

    public String getReport(Customer customer) {
        return customer.statement();
    }

    public String getHtmlReport(Customer customer) {
        return customer.htmlStatement();
    }
}
