package pl.kkurowski.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal credit;
    private BigDecimal balance;

    public CreditCard(String cardNumber)
    {

    }

    public void assignCreditLimit(BigDecimal creditLimit)
    {
        if (this.credit != null)
        {
            throw new CreditCantBeModifiedException();
        }
        this.credit = creditLimit;
        this.balance = credit;
    }

    public BigDecimal getBalance()
    {
        return balance;
    }

    public void withdraw (BigDecimal money)
    {
        if(cantAfford(money))
        {
            throw new NotEnoughFoundsException();
        }
        this.balance = this.balance.subtract(money);
    }

    private boolean cantAfford(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) < 0;
    }
}
