import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static ArrayList<String> menuStrings = new ArrayList<>(Arrays.asList(
            "Список команд: \n",
            "\t1. Создать клиента.\n",
            "\t2. Открыть дебетовый счёт.\n",
            "\t3. Открыть кредитный счёт.\n",
            "\t4. Пополнить.\n",
            "\t5. Снять.\n",
            "\t6. Перевести.\n",
            "\t7. Показать счета клиента.\n",
            "\t8. Показать транзакции.\n",
            "\t9. Отчёт банка.\n",
            "\t10. Выход.\n",
            "Введите номер действия (целое число): \n"
    ));

    public static void printMenu(ArrayList<String> menuStrings) {
        for (String string : menuStrings) {
            System.out.print(string);
        }
    }

    public static void createCustomer(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '1. Создать клиента'.\n");
        System.out.println("Введите полное имя клиента:");
        String customerFullName = scanner.nextLine();

        if (customerFullName.trim().isEmpty()) {
            System.out.println("Введено пустое имя клиента.");
            return;
        }

        Customer customer = bank.createCustomer(customerFullName);
        System.out.printf("Создан клиент с именем %s и ID='%s'.\n\n", customer.getFullname(),
                customer.getId());
    }

    public static void openDebitAccount(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '2. Открыть дебетовый счёт'.\n");
        System.out.println("Введите ID имя клиента:");
        int customerId = scanner.nextInt();

        if (customerId < 0) {
            System.out.println("Введен неверный ID клиента.");
            return;
        }

        Customer customer = bank.findCustomer(customerId);

        if (customer == null) {
            System.out.println("Клиент с заданным ID не найден.");
            return;
        }

        Account debitAccount = bank.openDebitAccount(customer);

        System.out.printf("Открыт дебетовый счет с номером '%s' для владельца '%s' (ID='%s').\n",
                debitAccount.getAccountNumber(),
                debitAccount.getOwner().getFullname(),
                debitAccount.getOwner().getId());
        System.out.printf("Текущий баланс: %.2f.\n\n", debitAccount.getBalance());
    }

    public static void openCreditAccount(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '3. Открыть кредитный счёт'.\n");
        System.out.println("Введите ID имя клиента:");
        int customerId = scanner.nextInt();

        if (customerId < 0) {
            System.out.println("Введен неверный ID клиента.");
            return;
        }

        Customer customer = bank.findCustomer(customerId);

        if (customer == null) {
            System.out.println("Клиент с заданным ID не найден.");
            return;
        }

        System.out.println("Введите кредитный лимит:");
        double creditLimit = scanner.nextDouble();

        if (creditLimit < 0) {
            System.out.println("Введен неверный кредитный лимит.");
            return;
        }

        Account creditAccount = bank.openCreditAccount(customer, creditLimit);

        System.out.printf("Открыт кредитный счет с номером '%s' для владельца '%s' (ID='%s') и лимитом '%.2f'.\n\n",
                creditAccount.getAccountNumber(),
                creditAccount.getOwner().getFullname(),
                creditAccount.getOwner().getId(),
                ((CreditAccount) creditAccount).getCreditLimit());
        System.out.printf("Текущий баланс: %.2f.\n\n", creditAccount.getBalance());
    }

    public static void deposit(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '4. Пополнить'.\n");

        try {
            System.out.println("Введите id клиента:");
            int customerId = scanner.nextInt();
            scanner.nextLine();

            if (customerId < 0) {
                System.out.println("Введен неверный ID клиента.");
                return;
            }

            Customer customer = bank.findCustomer(customerId);
            if (customer == null) {
                System.out.println("Клиент с заданным ID не найден.");
                return;
            }

            System.out.println("Введите номер счёта:");
            String accountNumber = scanner.nextLine();

            if (accountNumber == null || accountNumber.trim().length() == 0) {
                System.out.println("Введен пустой номер счёта.");
                return;
            }

            Account account = bank.findAccount(accountNumber);
            if (account == null) {
                System.out.println("Счёт с заданным номером не найден.");
                return;
            }

            System.out.println("Введите сумму пополнения:");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            boolean status = bank.deposit(account.getAccountNumber(), amount);

            if (!status) {
                System.out.println("Не удалось пополнить счёт.");
                return;
            }

            System.out.printf("Успешно пополнен счет с номером '%s' на сумму '%.2f'.\n",
                    account.getAccountNumber(), amount);
            System.out.printf("Текущий баланс: %.2f.\n\n", account.getBalance());

        } catch (Exception e) {
            System.out.println("Ошибка ввода. Введите корректные данные.\n");
            scanner.nextLine();
            return;
        }
    }

    public static void withdraw(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '5. Снять'.\n");

        try {
            System.out.println("Введите ID клиента:");
            int customerId = scanner.nextInt();
            scanner.nextLine();

            if (customerId < 0) {
                System.out.println("Введен неверный ID клиента.");
                return;
            }

            Customer customer = bank.findCustomer(customerId);
            if (customer == null) {
                System.out.println("Клиент с заданным ID не найден.");
                return;
            }

            System.out.println("Введите номер счёта:");
            String accountNumber = scanner.nextLine();

            if (accountNumber == null || accountNumber.trim().length() == 0) {
                System.out.println("Введен пустой номер счёта.");
                return;
            }

            Account account = bank.findAccount(accountNumber);
            if (account == null) {
                System.out.println("Счёт с заданным номером не найден.");
                return;
            }

            System.out.println("Введите сумму снятия:");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            boolean status = bank.withdraw(account.getAccountNumber(), amount);

            if (!status) {
                System.out.println("Не удалось снять указанную сумму.");
                return;
            }

            System.out.printf("Успешно снята сумма '%.2f' со счёта с номером '%s'.\n",
                    amount, account.getAccountNumber());
            System.out.printf("Текущий баланс: %.2f.\n\n", account.getBalance());

        } catch (Exception e) {
            System.out.println("Ошибка ввода. Введите корректные данные.\n");
            scanner.nextLine();
            return;
        }
    }

    public static void transfer(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '6. Перевести'.\n");

        try {
            System.out.println("Введите ID клиента:");
            int customerId = scanner.nextInt();
            scanner.nextLine();

            if (customerId < 0) {
                System.out.println("Введен неверный ID клиента.");
                return;
            }

            Customer customer = bank.findCustomer(customerId);
            if (customer == null) {
                System.out.println("Клиент с заданным ID не найден.");
                return;
            }

            System.out.println("Введите номер счёта:");
            String accountNumberFrom = scanner.nextLine();

            if (accountNumberFrom == null || accountNumberFrom.trim().length() == 0) {
                System.out.println("Введен пустой номер счёта.");
                return;
            }

            Account accountFrom = bank.findAccount(accountNumberFrom);
            if (accountFrom == null) {
                System.out.println("Счёт с заданным номером не найден.");
                return;
            }

            System.out.println("Введите номер счёта для перевода:");
            String accountNumberTo = scanner.nextLine();

            if (accountNumberTo == null || accountNumberTo.trim().length() == 0) {
                System.out.println("Введен пустой номер счёта.");
                return;
            }

            Account accountTo = bank.findAccount(accountNumberTo);
            if (accountTo == null) {
                System.out.println("Счёт для перевода с заданным номером не найден.");
                return;
            }

            System.out.println("Введите сумму перевода:");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            boolean status = bank.transfer(accountFrom.getAccountNumber(), accountTo.getAccountNumber(), amount);

            if (!status) {
                System.out.println("Не удалось перевести указанную сумму.");
                return;
            }

            System.out.printf("Успешно выполнен перевод суммы '%.2f' со счёта с номером '%s' на счет с номером '%s'.\n",
                    amount, accountFrom.getAccountNumber(), accountTo.getAccountNumber());
            System.out.printf("Текущий баланс: %.2f.\n\n", accountFrom.getBalance());

        } catch (Exception e) {
            System.out.println("Ошибка ввода. Введите корректные данные.\n");
            scanner.nextLine();
            return;
        }
    }

    public static void printCustomerAccounts(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '7. Показать счета клиента'.\n");

        try {
            System.out.println("Введите ID клиента:");
            int customerId = scanner.nextInt();
            scanner.nextLine();

            if (customerId < 0) {
                System.out.println("Введен неверный ID клиента.");
                return;
            }

            Customer customer = bank.findCustomer(customerId);
            if (customer == null) {
                System.out.println("Клиент с заданным ID не найден.");
                return;
            }

            bank.printCustomerAccounts(customerId);
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Введите корректные данные.\n");
            scanner.nextLine();
            return;
        }
    }

    public static void printTransactions(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '8. Показать транзакции'.\n");
        bank.printTransactions();
        return;
    }

    public static void printReport(Scanner scanner, Bank bank) {
        System.out.println("Выбрана команда '9. Отчёт банка'.\n");
        bank.printReport();
        return;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean runFlag = true;

        while(runFlag) {
            printMenu(menuStrings);

            int actionNumber;
            try {
                actionNumber = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Введите число.\n");
                scanner.nextLine();
                continue;
            }

            switch(actionNumber) {
                case 1  -> createCustomer(scanner, bank);
                case 2  -> openDebitAccount(scanner, bank);
                case 3  -> openCreditAccount(scanner, bank);
                case 4  -> deposit(scanner, bank);
                case 5  -> withdraw(scanner, bank);
                case 6  -> transfer(scanner, bank);
                case 7  -> printCustomerAccounts(scanner, bank);
                case 8  -> printTransactions(scanner, bank);
                case 9  -> printReport(scanner, bank);
                case 10 -> {
                    System.out.println("Выбрана команда '10. Выход'.\n");
                    runFlag = false;
                    break;
                }
                default -> System.out.println("Введён некорректный номер команды. Повторите ввод.\n");
            }
        }
    }
}