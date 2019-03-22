import org.easymock.EasyMock;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.*;

import static org.easymock.EasyMock.expect;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)

public class LoanMockTest {

    @Test
    public void testCustomerCanTakeOutLoan() throws Exception {
        Customer customer = new Customer("John");

        //Create mock Loan object
        Loan mockLoan = EasyMock.createMock(Loan.class);


        //PowerMock will intercept calls to Loan and return mockLoan
        PowerMock.expectNew(Loan.class, 5000.0, 5).andReturn(mockLoan);

        //expected return value
        expect(mockLoan.getMonthlyPayment()).andReturn(96.66);

        //make mockLoan active
        PowerMock.replay(mockLoan, Loan.class);

        double expected = 96.66;
        customer.takeoutloan();
        double actual = customer.getMonthlypayments();
        assertEquals(expected, actual,0.05);

        /* verify that PowerMock was called and used */
        PowerMock.verify(mockLoan, Loan.class);
    }
}
