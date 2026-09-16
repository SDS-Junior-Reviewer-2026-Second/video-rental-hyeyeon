package com.videorental;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    public static final String NAME = "NAME_NOT_IMPORTANT";
    public static final String TITLE = "TITLE_NOT_IMPORTANT";

    Customer customer = new Customer(NAME);

    private static Rental createRentalFor(int daysRented, int priceCode) {
        Movie movie = new Movie(TITLE, priceCode);
        return new Rental(movie, daysRented);
    }

    @Test
    void statement() {
        customer.addRental(createRentalFor(4, Movie.REGULAR));

        String result = customer.statement();
        System.out.println(result);
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t5.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter pointers";


        assertEquals(expected, result);
    }



    @Test
    void statement2() {

        customer.addRental(createRentalFor(3, Movie.CHILDRENS));
        customer.addRental(createRentalFor(2, Movie.REGULAR));
        customer.addRental(createRentalFor(6, Movie.NEW_RELEASE));
        customer.addRental(createRentalFor(2, Movie.REGULAR));
        customer.addRental(createRentalFor(4, Movie.CHILDRENS));
        customer.addRental(createRentalFor(3, Movie.NEW_RELEASE));

        String result = customer.statement();
        System.out.println(result);
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t1.5(TITLE_NOT_IMPORTANT)\n" +
                "\t2.0(TITLE_NOT_IMPORTANT)\n" +
                "\t18.0(TITLE_NOT_IMPORTANT)\n" +
                "\t2.0(TITLE_NOT_IMPORTANT)\n" +
                "\t3.0(TITLE_NOT_IMPORTANT)\n" +
                "\t9.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 35.5\n" +
                "You earned 8 frequent renter pointers";

        assertEquals(expected, result);
    }

    @Test
    void noReantal(){
        String result = customer.statement();
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers";
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    void noRegular2(){
        customer.addRental(createRentalFor(2, Movie.REGULAR));
        String result = customer.statement();
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t2.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter pointers";
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    void noRegular3(){
        customer.addRental(createRentalFor(3, Movie.REGULAR));
        String result = customer.statement();
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t3.5(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter pointers";
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    void newRelease(){
        customer.addRental(createRentalFor(1, Movie.NEW_RELEASE));
        String result = customer.statement();
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t3.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter pointers";
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    void newRelease2(){
        customer.addRental(createRentalFor(2, Movie.NEW_RELEASE));
        String result = customer.statement();
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t6.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter pointers";
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    void children4(){
        customer.addRental(createRentalFor(4, Movie.CHILDRENS));
        String result = customer.statement();
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t3.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter pointers";
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    void children3(){
        customer.addRental(createRentalFor(3, Movie.CHILDRENS));
        String result = customer.statement();
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t1.5(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter pointers";
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    void setTest(){
        Movie movie = new Movie(TITLE, Movie.REGULAR);
        movie.setPriceCode(Movie.CHILDRENS);
        customer.addRental(new Rental(movie, 3));
        String result = customer.statement();
        String expected = "Rental Record for NAME_NOT_IMPORTANT\n" +
                "\t1.5(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter pointers";
        System.out.println(result);
        assertEquals(expected, result);
    }

}
