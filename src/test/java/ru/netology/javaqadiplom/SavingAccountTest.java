package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    @Test
    public void ifMaxBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                0,
                5
        );

        Assertions.assertEquals(0, account.getMaxBalance());
    }

    @Test
    public void ifMinBalanceLessThanZero() {
        SavingAccount account = new SavingAccount(
                0,
                -100,
                5000,
                5
        );

        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    public void shouldThrowExceptionIfMinBalanceMoreMaxBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2000,
                    20_000,
                    10_000,
                    5);

        });
    }

    @Test
    public void shouldThrowExceptionIfInitialBalanceLessMinBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    200,
                    2_000,
                    10_000,
                    5);

        });
    }

    @Test
    public void shouldThrowExceptionIfInitialBalanceMoreThanMaxBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    20_000,
                    2_000,
                    10_000,
                    5);

        });
    }

    @Test
    public void negativeRateTest() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    200,
                    1000,
                    10_000,
                    -15);

        });
    }


    @Test
    public void shouldPayReduceBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldNotPayLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1500);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldNotPayWhenAmountMoreThanInitBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(3000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldNotPayWhenAmountIsNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-1);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountEqualsBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(2000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddEqualToMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test
    public void shouldNotAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(12_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddWhenAmountIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotAddWhenAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotAddWhenBalanceLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                5_000,
                10_000,
                5
        );

        account.add(2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddYearChangeBalance() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(30, account.yearChange());
    }


}








