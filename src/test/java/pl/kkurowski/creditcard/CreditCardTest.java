package pl.kkurowski.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CreditCardTest
{
    @Test
    void itAllowsToAssignCreditLimit()
    {
        //Arrange
        CreditCard card = new CreditCard("1234-56789");
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000)
                .equals(card.getBalance());
    }
}
