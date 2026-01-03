import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Customer customer1 = new Customer("Ivanov");
//        System.out.println(customer1.getId());
//        System.out.println(customer1.getFullname());
//
//        Customer customer2 = new Customer("Petrov");
//        System.out.println(customer2.getId());
//        System.out.println(customer2.getFullname());

        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Список команд: ");
            System.out.println("\t1. Создать клиента.");
            System.out.println("\t2. Открыть дебетовый счёт.");
            System.out.println("\t3. Открыть кредитный счёт.");
            System.out.println("\t4. Пополнить.");
            System.out.println("\t5. Снять.");
            System.out.println("\t6. Перевести.");
            System.out.println("\t7. Показать счета клиента.");
            System.out.println("\t8. Показать транзакции.");
            System.out.println("\t9. Отчёт банка.");
            System.out.println("\t10. Выход.");
            System.out.println();
            System.out.println("Введите номер действия (целое число): ");

//            int actionNumber = scanner.nextInt();   // todo: обработка не чисел
            int actionNumber;
            try {
                actionNumber = scanner.nextInt();
                scanner.nextLine(); // Очищаем буфер после nextInt()
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Введите число.\n");
                scanner.nextLine(); // Очищаем неверный ввод
                continue;
            }

            switch(actionNumber) {
                case 1  -> {
                    System.out.println("Выбрана команда '1. Создать клиента'.\n");
                    System.out.println("Введите полное имя клиента:");
                    String customerFullName = scanner.nextLine();

                    if (customerFullName.trim().isEmpty()) {
                        System.out.println("Введено пустое имя клиента. Повторите ввод.");
                        break;
                    }

                    Customer customer = bank.createCustomer(customerFullName);
                    System.out.printf("Создан клиент с именем %s и id='%s'.\n\n", customer.getFullname(),
                                                                                  customer.getId());
                }
                case 2  -> {
                    System.out.println("Выбрана команда '2. Открыть дебетовый счёт'.\n");
                    System.out.println("Введите id имя клиента:");
                    int customerId = scanner.nextInt();

                    if (customerId < 0) {
                        System.out.println("Введен неверный id клиента. Повторите ввод.");
                        break;
                    }

                    Customer customer = bank.findCustomer(customerId);

                    if (customer == null) {
                        System.out.println("Клиент с заданным id не найден.");
                        break;
                    }

                    Account debitAccount = bank.openDebitAccount(customer);

                    System.out.printf("Открыт дебетовый счет с номером '%s' для владельца '%s' (id='%s').\n\n",
                                      debitAccount.getAccountNumber(),
                                      debitAccount.getOwner().getFullname(),
                                      debitAccount.getOwner().getId());
                }
                case 3  -> {
                    System.out.println("Выбрана команда '3. Открыть кредитный счёт'.\n");
                    System.out.println("Введите id имя клиента:");
                    int customerId = scanner.nextInt();

                    if (customerId < 0) {
                        System.out.println("Введен неверный id клиента.");
                        break;
                    }

                    Customer customer = bank.findCustomer(customerId);

                    if (customer == null) {
                        System.out.println("Клиент с заданным id не найден.");
                        break;
                    }

                    System.out.println("Введите кредитный лимит:");
                    double creditLimit = scanner.nextDouble();

                    if (creditLimit < 0) {
                        System.out.println("Введен неверный кредитный лимит.");
                        break;
                    }

                    Account creditAccount = bank.openCreditAccount(customer, creditLimit);

                    System.out.printf("Открыт кредитный счет с номером '%s' для владельца '%s' (id='%s') и лимитом '%.2f'.\n\n",
                            creditAccount.getAccountNumber(),
                            creditAccount.getOwner().getFullname(),
                            creditAccount.getOwner().getId(),
                            ((CreditAccount) creditAccount).getCreditLimit());
                }
                case 4  -> System.out.println("Выбрана команда '4. Пополнить'.\n");
                case 5  -> System.out.println("Выбрана команда '5. Снять'.\n");
                case 6  -> System.out.println("Выбрана команда '6. Перевести'.\n");
                case 7  -> System.out.println("Выбрана команда '7. Показать счета клиента'.\n");
                case 8  -> System.out.println("Выбрана команда '8. Показать транзакции'.\n");
                case 9  -> System.out.println("Выбрана команда '9. Отчёт банка'.\n");
                case 10 -> System.out.println("Выбрана команда '10. Выход'.\n");
                default -> System.out.println("Введён некорректный номер команды. Повторите ввод.\n");
            }
        }
    }
}