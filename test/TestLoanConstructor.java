import org.junit.Test;

import static org.junit.Assert.*;

public class TestLoanConstructor {


    private static final double AMOUNT = 500;

    private static final int PERIOD = 1;

    Loan loan = new Loan(AMOUNT,PERIOD);

    //Constructor Tests
    @Test
    public void constructorTestPos() {
        assertEquals(AMOUNT, loan.getAmount(), 0.00);
        assertEquals(PERIOD, loan.getPeriod(), 0.00);
        assertEquals(10, loan.getRate(),0.00);
    }

    //Default Constructor Test -- Added after code coverage
    @Test
    public void constructorTestDefault() {
        new Loan();
    }

    //Public method tests

    //test getAmount method
    @Test
    public void testAmount() {
        assertEquals(AMOUNT, loan.getAmount(), 0.00);
    }

    //test getAmount method
    @Test
    public void testPeriod() {
        assertEquals(PERIOD, loan.getPeriod(), 0.00);
    }

    //test getRate method
    @Test
    public void testRate() {
        assertEquals(PERIOD, loan.getPeriod(), 0.00);
    }

    //test getMonthlyPayment method
    @Test
    public void testMonthlyPayment() {
        assertEquals(43.96, loan.getMonthlyPayment(), 0.005);
    }

    //test testTotalPayment method
    @Test
    public void testTotalPayment() {
        assertEquals(527.50, loan.getTotalPayment(), 0.005);
    }
}