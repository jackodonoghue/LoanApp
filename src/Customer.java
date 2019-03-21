import java.io.Serializable;

/**
 * Created by T00025164 on 28/02/2018.
 */

public class Customer implements Serializable {
    private String name;
    private double monthly_payments;
    private Loan loan;

    public Customer() {
        this("Name unknown");
    }
    public Customer(String name){
        setName(name);
        setMonthlyPayments(0.0);
    }

    public Customer(String name, double mpayment){
        setName(name);
        setMonthlyPayments(mpayment);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMonthlyPayments(double mpayment)
    {
        this.monthly_payments = mpayment;
    }

    public String getName()
    {
        return name;
    }
    public double getMonthlypayments()
    {
        return monthly_payments;
    }
    public String toString()
    {
        return "Name: " + getName() + " Payments: " + getMonthlypayments();
    }

    public void takeoutloan(){
        Loan loan = new Loan(5000.0,5);
        monthly_payments = loan.getMonthlyPayment();
    }
}
