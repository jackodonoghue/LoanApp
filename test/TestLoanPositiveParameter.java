import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TestLoanPositiveParameter {

    private double expected;
    private double amount;
    private int period;

    public TestLoanPositiveParameter(double amount, int period, int expected) {
        this.amount = amount;
        this.period = period;
        this.expected = expected;

    }

    @Parameterized.Parameters(name = "{index}: amount={0}, period={1}, rate={2}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {500, 1, 10},
                {500.01, 4, 6},
                {4999.99, 3, 10},
                {5000, 3, 10},
                {5001, 4, 5},
                {5001.01, 3, 8},
                {9999.99, 5, 5},
                {10000, 2, 8}
                //All 8 tests run as expected
        });
    }

    @Test
    public void testRate() {
        Loan loan = new Loan(amount, period);
        assertEquals(expected, loan.getRate(), 0.00);
    }
}
