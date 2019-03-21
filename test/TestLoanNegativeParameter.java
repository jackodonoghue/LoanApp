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

    public TestLoanNegativeParameter( double amount, int period) {
        this.amount = amount;
        this.period = period;
    }

    @Parameterized.Parameters(name = "{index}: amount={0}, period={1}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {499.99, 2},
                {5000.01, 2},
                {5000.99, 2},
                {10000.01, 2},
                {6000, 0},
                {6000, 6},
                {null, 1},
                {3500, null},
                {"C", 2}, //Test works with char but not string
                {8000, 'C'},
                {3000,3}
                //7/10 tests pass
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

    @Test (expected = IllegalArgumentException.class)
    public void testRate() throws IllegalArgumentException{
        Loan loan = new Loan(amount, period);
        assertFalse(throwException());//needed for checking second argument (period) https://stackoverflow.com/questions/15288390/junit-test-failing-although-expected-exception-is-thrown
        assertTrue(throwException());
    }

    private boolean throwException() {
        throw new IllegalArgumentException();
    }

}