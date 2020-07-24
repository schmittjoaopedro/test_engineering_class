package practice.refactoring;

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
    }

}
