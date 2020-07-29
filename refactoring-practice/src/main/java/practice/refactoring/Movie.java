package practice.refactoring;

import practice.refactoring.price.ChildrenPrice;
import practice.refactoring.price.NewReleasePrice;
import practice.refactoring.price.Price;
import practice.refactoring.price.RegularPrice;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;
    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            case CHILDREN:
                _price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

}
