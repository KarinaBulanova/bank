package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void testOnZeroInitialBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void testOnZeroCreditLimit() {
        CreditAccount account = new CreditAccount(
                1000,
                0,
                15
        );
        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void testOnZeroRate() {
        CreditAccount account = new CreditAccount(
                1000,
                5000,
                0
        );
        Assertions.assertEquals(0, account.getRate());
    }


    @Test
    public void shouldThrowAnExceptionForRate() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5000,
                    -15
            );

        });

    }

    @Test
    public void shouldThrowAnExceptionForCreditLimit() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    -5000,
                    15
            );

        });

    }

    @Test
    public void shouldThrowAnExceptionForBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -6000,
                    5000,
                    15
            );

        });

    }


    @Test
    public void shouldReducePositiveBalanceByPay() {

        CreditAccount account = new CreditAccount(
                4000,
                5_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(1000, account.getBalance());


    }

    @Test
    public void shouldReduceZeroBalanceByPay() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(-3000, account.getBalance());


    }

    @Test
    public void shouldReduceBalanceByEqualsPay() {

        CreditAccount account = new CreditAccount(
                4000,
                5_000,
                15
        );

        account.pay(4000);

        Assertions.assertEquals(0, account.getBalance());


    }

    @Test
    public void notShouldReduceBalanceByPayMoreLimit() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6000);

        Assertions.assertEquals(0, account.getBalance());


    }

    @Test
    public void notShouldReduceBalanceByZeroPay() {

        CreditAccount account = new CreditAccount(
                4000,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(4000, account.getBalance());


    }

    @Test
    public void notShouldReduceBalanceByIncorrectPay() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(-3000);

        Assertions.assertEquals(0, account.getBalance());


    }

    @Test
    public void ShouldReduceBalanceByPayEqualsLimitPlusBalance() {

        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.pay(6000);

        Assertions.assertEquals(-5000, account.getBalance());


    }


    @Test
    public void shouldAddZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);


        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void notShouldChangeBalanceOnNegativeAdd() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(-3000);


        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);


        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void notShouldChangeBalanceOnZeroAdd() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(0);


        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldCalculatePercentOnNegativeBalance() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.pay(2000);

        Assertions.assertEquals(-150, account.yearChange());


    }

    @Test
    public void notShouldCalculatePercentOnPositiveBalance() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );

        account.pay(1000);

        Assertions.assertEquals(0, account.yearChange());


    }

    @Test
    public void notShouldCalculatePercentOnZeroBalance() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );

        account.pay(2000);

        Assertions.assertEquals(0, account.yearChange());


    }


}