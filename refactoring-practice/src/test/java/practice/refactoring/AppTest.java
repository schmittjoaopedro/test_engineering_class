package practice.refactoring;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    private App app = new App();

    /**
     * Bob renting:
     * 1- Ford vs Ferrari, a new release for 2 days
     * 2- Jay and Silent Bob Reboot, a new release for 3 days
     * <p>
     * Should expect:
     * - Price for movie 1 = 6.0
     * - Price for movie 2 = 9.0
     * - Total price = 15.0
     * - Points earned = 4
     */
    @Test
    public void rentNewReleasesTest() {
        Movie movie1 = new Movie("Ford vs Ferrari", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 2);

        Movie movie2 = new Movie("Jay and Silent Bob Reboot", Movie.NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 3);

        Customer customer = new Customer("Bob");
        customer.addRental(rental1);
        customer.addRental(rental2);

        String response = app.getReport(customer);
        Assert.assertEquals(response, "Rental Record for Bob\n" +
                "\tFord vs Ferrari\t6.0\n" +
                "\tJay and Silent Bob Reboot\t9.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 4 frequent renter points");

        String htmlResponse = app.getHtmlReport(customer);
        Assert.assertEquals(htmlResponse, "<H1>Rentals for <EM>Bob</EM></H1><P>\n" +
                "Ford vs Ferrari: 6.0<BR>\n" +
                "Jay and Silent Bob Reboot: 9.0<BR>\n" +
                "<P>You owe <EM>15.0</EM><P>\n" +
                "On this rental you earned <EM>4</EM> frequent renter points<P>");
    }

    /**
     * Lisa renting:
     * 1- Deadpool 2, a regular for 2 days
     * 2- Interstelar, a regular for 3 days
     * <p>
     * Should expect:
     * - Price for movie 1 = 2.0
     * - Price for movie 2 = 3.5
     * - Total price = 5.5
     * - Points earned = 2
     */
    @Test
    public void rentRegularTest() {
        Movie movie1 = new Movie("Deadpool 2", Movie.REGULAR);
        Rental rental1 = new Rental(movie1, 2);

        Movie movie2 = new Movie("Interstelar", Movie.REGULAR);
        Rental rental2 = new Rental(movie2, 3);

        Customer customer = new Customer("Lisa");
        customer.addRental(rental1);
        customer.addRental(rental2);

        String response = app.getReport(customer);
        Assert.assertEquals(response, "Rental Record for Lisa\n" +
                "\tDeadpool 2\t2.0\n" +
                "\tInterstelar\t3.5\n" +
                "Amount owed is 5.5\n" +
                "You earned 2 frequent renter points");

        String htmlResponse = app.getHtmlReport(customer);
        Assert.assertEquals(htmlResponse, "<H1>Rentals for <EM>Lisa</EM></H1><P>\n" +
                "Deadpool 2: 2.0<BR>\n" +
                "Interstelar: 3.5<BR>\n" +
                "<P>You owe <EM>5.5</EM><P>\n" +
                "On this rental you earned <EM>2</EM> frequent renter points<P>");
    }

    /**
     * Mark renting:
     * 1- Harry Potter and the Philosopher's Stone, a children movie for 3 days
     * 2- Harry Potter and the Goblet of Fire, a children movie for 4 days
     * <p>
     * Should expect:
     * - Price for movie 1 = 1.5
     * - Price for movie 2 = 3.0
     * - Total price = 4.5
     * - Points earned = 2
     */
    @Test
    public void rentChildrenTest() {
        Movie movie1 = new Movie("Harry Potter and the Philosopher's Stone", Movie.CHILDREN);
        Rental rental1 = new Rental(movie1, 3);

        Movie movie2 = new Movie("Harry Potter and the Goblet of Fire", Movie.CHILDREN);
        Rental rental2 = new Rental(movie2, 4);

        Customer customer = new Customer("Mark");
        customer.addRental(rental1);
        customer.addRental(rental2);

        String response = app.getReport(customer);
        Assert.assertEquals(response, "Rental Record for Mark\n" +
                "\tHarry Potter and the Philosopher's Stone\t1.5\n" +
                "\tHarry Potter and the Goblet of Fire\t3.0\n" +
                "Amount owed is 4.5\n" +
                "You earned 2 frequent renter points");

        String htmlResponse = app.getHtmlReport(customer);
        Assert.assertEquals(htmlResponse, "<H1>Rentals for <EM>Mark</EM></H1><P>\n" +
                "Harry Potter and the Philosopher's Stone: 1.5<BR>\n" +
                "Harry Potter and the Goblet of Fire: 3.0<BR>\n" +
                "<P>You owe <EM>4.5</EM><P>\n" +
                "On this rental you earned <EM>2</EM> frequent renter points<P>");
    }

}
