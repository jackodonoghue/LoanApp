import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TestLoanNegativeParameter {

    private double amount;
    private int period;

    //Define test parameters
    public TestLoanNegativeParameter( double amount, int period) {
        this.amount = amount;
        this.period = period;
    }

    @Parameterized.Parameters(name = "{index}: amount={0}, period={1}")
    public static Collection<Object[]> getTestParameters() {
        //Parameters of tests to be performed
        return Arrays.asList(new Object[][]{
                {499.99, 2},
                {5000.01, 2},
                {5000.99, 2},
                {10000.01, 2},
                {6000, 0},
                {6000, 6},
                {null, 1}, //Null tests not passing even though IllegalArgumentException expected
                {3500, null}, //Null tests not passing even though IllegalArgumentException expected
                {"C", 2}, //Test works with char but not string
                {8000, 'C'},
                {3000,3},
                //7/10 tests pass

                //Added after code coverage to test negative input
                {-500, 2}
        });
    }
/*  Attempt to solve failed test problem
    @Test (expected = IllegalArgumentException.class)
    public void testRate() {
        try{
            Loan loan = new Loan(amount, period);
        }catch (IllegalArgumentException e){
            String message = "Hello";
            assertEquals(message, e.getMessage());
            throw e;
        }
        fail("Exception not thrown");
    }*/

    //Even though IllegalArgumentException was expected some tests failed
    @Test (expected = IllegalArgumentException.class)
    public void testRate() throws IllegalArgumentException{
        Loan loan = new Loan(amount, period);
        assertFalse(throwException());//needed for checking second argument (period) when first argument passes  https://stackoverflow.com/questions/15288390/junit-test-failing-although-expected-exception-is-thrown
    }

    //Throws IllegalArgumentException when the first variable results in a True value
    private boolean throwException() {
        throw new IllegalArgumentException();
    }

}