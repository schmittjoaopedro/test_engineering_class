package practice.refactoring.price;

public abstract class Price {

    public abstract double getCharge(int daysRented);

    public abstract int getFrequentRenterPoints(int daysRented);
}
