package pl.kkurowski.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest
{
    @Test
    void itAllowsToAssignCreditLimit()
    {
        //Arrange
        CreditCard card = thereIsExampleCreditCard();
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000)
                .equals(card.getBalance());
    }

    @Test
    void itAllowsToAssignCreditLimitV2()
    {
        //Arrange
        CreditCard card = thereIsExampleCreditCard();
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(2000));
        //Assert
        assertEquals(BigDecimal.valueOf(2000),card.getBalance());
    }

    private static CreditCard thereIsExampleCreditCard() {
        CreditCard card = new CreditCard("1234-56789");
        return card;
    }

    @Test
    void itDenyToChangeAlreadyAssignCredit()
    {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(2000));

        try
        {
            card.assignCreditLimit(BigDecimal.valueOf(3000));
            fail("Exception should be thrown");
        }
        catch (CreditCantBeModifiedException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void itDenyToChangeAlreadyAssignCreditV2()
    {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(2000));

        assertThrows(
                CreditCantBeModifiedException.class,
                () -> card.assignCreditLimit(BigDecimal.valueOf(3000)));
    }

    @Test
    void itAllowToPayBills()
    {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(2000));

        card.withdraw(BigDecimal.valueOf(450));

        assertEquals(BigDecimal.valueOf(1550), card.getBalance());
    }

    @Test
    void itAllowToPayBillsV2()
    {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(900));

        assertThrows(NotEnoughFoundsException.class, () -> card.withdraw(BigDecimal.valueOf(200)));
    }
}
