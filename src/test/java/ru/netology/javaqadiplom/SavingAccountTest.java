package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class SavingAccountTest {
        @Test // Минимальный баланс не может быть больше максимального, метод нужно доработать
        public void shouldThrowExceptionIfMinBalanceMoreMaxBalance() {


            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                SavingAccount account = new SavingAccount(
                        2000,
                        20_000,
                        10_000,
                        5);

            });
        }

        @Test // Начальный баланс не может быть меньше минимального, метод нужно доработать
        public void shouldThrowExceptionIfInitialBalanceLessMinBalance() {


            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                SavingAccount account = new SavingAccount(
                        200,
                        2_000,
                        10_000,
                        5);

            });
        }

        @Test // Начальный баланс не может быть больше максимального, метод нужно доработать
        public void shouldThrowExceptionIfInitialBalanceMoreThanMaxBalance() {


            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                SavingAccount account = new SavingAccount(
                        20_000,
                        2_000,
                        10_000,
                        5);

            });
        }

        @Test // Накопительная ставка всегда положительная
        public void negativeRateTest() {


            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                SavingAccount account = new SavingAccount(
                        200,
                        1000,
                        10_000,
                        -15);

            });
        }


        @Test // баланс должен уменьшиться на сумму покупки
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
        // баланс не может быть меньше минимального после покупки, ошибка в методе pay
        public void shouldNotPayLessThanMinBalance() {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    5
            );

            account.pay(4000);

            Assertions.assertEquals(2000, account.getBalance());
        }

        @Test // баланс должен увеличиться на сумму пополения, ошибка в методе add
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
        // после пополнения баланс не может быть больше максимального, операция должна завершиться ничего не поменяв на счете
        public void shouldAddMoreThanMaxBalance() {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    5
            );

            account.add(12_000);

            Assertions.assertEquals(2_000, account.getBalance());
        }

        @Test // расчет процентов на остаток счета
        public void shouldAddYearChangeBalance() {
            LocalDate date = LocalDate.of(2000, 01, 01);
            date = date.plusYears(1);

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









