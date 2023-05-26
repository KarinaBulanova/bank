package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {


    @Test
    public void shouldThrowAnExceptionForRate() {  //Тест на выброс исключения. Должен создавать обьект с заданными корректными параметрами, иначе исключение


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5000,
                    -15
            );

        });

    }

    @Test
    public void shouldThrowAnExceptionForCreditLimit() {  //Тест на выброс исключения. Должен создавать обьект с заданными корректными параметрами, иначе исключение


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    -5000,
                    15
            );

        });

    }

    @Test
    public void shouldThrowAnExceptionForBalance() {  //Тест на выброс исключения. Должен создавать обьект с заданными корректными параметрами, иначе исключение


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -6000,
                    5000,
                    15
            );

        });

    }


    @Test
    public void shouldReducePositiveBalanceByPay() {        //неправильный метод pay. Баланс должен уменьшаться на сумму покупки

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(-2000, account.getBalance());


    }

    @Test
    public void shouldReduceNegativeBalanceByPay() {        //неправильный метод pay. Баланс должен уменьшаться на сумму покупки, при балансе меньше лимита, операция должна завершиться ничего не поменяв на счете

        CreditAccount account = new CreditAccount(
                -5000,
                5_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(-5000, account.getBalance());


    }


    @Test
    public void shouldAddToPositiveBalance() {    //метод на пополнение баланса
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);


        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {            //метод на пополнение баланса. баланс не увеличивается на сумму пополнения при отрицательном балансе и при балансе больше 0
        CreditAccount account = new CreditAccount(
                -20,
                5_000,
                15
        );

        account.add(3000);


        Assertions.assertEquals(2980, account.getBalance());
    }

    @Test
    public void shouldCalculateRateToNegativeBalanceYearChange() {  //метод на расчет годового процента
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        account.getRate();

        Assertions.assertEquals(-30, account.yearChange());


    }

    @Test
    public void shouldCalculateRateToPositiveBalanceYearChange() {          //дописать метод, при положительном балансе считает процент, не хватает условия
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.getRate();

        Assertions.assertEquals(0, account.yearChange());


    }


}
